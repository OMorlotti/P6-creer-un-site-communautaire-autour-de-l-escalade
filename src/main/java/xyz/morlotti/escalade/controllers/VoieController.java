package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.BeanException;
import xyz.morlotti.escalade.models.beans.Sector;
import xyz.morlotti.escalade.models.beans.Voie;
import xyz.morlotti.escalade.models.daos.SectorDAO;
import xyz.morlotti.escalade.models.daos.VoieDAO;

@Controller
public class VoieController
{
    @Autowired
    private VoieDAO voieDAO;

    @Autowired
    private SectorDAO sectorDAO;

    @RequestMapping(path = "/voies", method = RequestMethod.GET)
    public String showVoies(
    	@RequestParam(name = "sector", required = false) Integer parentSector, // Le post parent est passé dans l'url en ajoutan ?spot=<id>, il est facultatif et dans ce cas, on aura null dans parentSpot
        Model model) throws Exception
        {
            model.addAttribute("title", "Voies");

            if(parentSector == null) {
                model.addAttribute("voies", voieDAO.list());
            }
            else {
                model.addAttribute("voies", voieDAO.list(parentSector));
            }

            model.addAttribute("sector", sectorDAO.list());

            return "showVoies";
        }

    @RequestMapping(path = "/voie/{id}", method = RequestMethod.GET)
    public String showVoie(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "Voie");

        model.addAttribute("voie", voieDAO.get(id));

        model.addAttribute("secteurs", sectorDAO.list());

        return "showUpdateVoie";
    }

    @RequestMapping(path = "/voie", method = RequestMethod.POST)
    public String addVoie(
        @RequestParam("height") float height,
        @RequestParam("sectorfk") int parentSectorId,
        Model model) throws Exception
    {
        Sector sector = sectorDAO.get(parentSectorId);

        Voie voie = new Voie();

        voie.setHeight(height);
        voie.setSectorFK(sector);

        voieDAO.add(voie);

        /**/

        model.addAttribute("message", "Voie ajoutée avec succès !");

        model.addAttribute("message_type", "success");

        return showVoies(parentSectorId, model);
    }

    @RequestMapping(path = "/voie/update/{id}", method = RequestMethod.POST)
    public String updateVoie(
        @PathVariable(value = "id") final int id,
        @RequestParam("height") float height,
        @RequestParam("sectorfk") int sectorFK,
        Model model) throws Exception
    {
        Sector sector = sectorDAO.get(sectorFK);

        Voie voie = voieDAO.get(id);

        int parentSectortId = voie.getSectorFK().getId();

        voie.setHeight(height);
        voie.setSectorFK(sector);

        voieDAO.update(voie);

        /**/

        model.addAttribute("message", "Secteur ajouté avec succès !");

        model.addAttribute("message_type", "success");

        return showVoies(parentSectorId, model);
    }

    @RequestMapping(path = "/voie/delete/{id}", method = RequestMethod.GET)
    public String deleteVoie(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        Voie voie = voieDAO.get(id);

        int parentSectorId = voie.getSectorFK().getId();

        voieDAO.delete(id);

        /**/

        model.addAttribute("message", "Secteur " + id + " supprimé avec succès !");

        model.addAttribute("message_type", "success");

        return showVoies(parentSectorId, model);
    }
}