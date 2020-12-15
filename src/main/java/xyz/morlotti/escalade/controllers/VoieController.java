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
    private SectorDAO secteurDAO;

    @RequestMapping(path = "/voies", method = RequestMethod.GET)
    public String showVoies(Model model) throws Exception
    {
        model.addAttribute("title", "Voies");

        model.addAttribute("voies", voieDAO.list());

        model.addAttribute("secteurs", secteurDAO.list());

        return "showVoies";
    }

    @RequestMapping(path = "/voie/{id}", method = RequestMethod.GET)
    public String showVoie(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "Voie");

        model.addAttribute("voie", voieDAO.get(id));

        model.addAttribute("secteurs", secteurDAO.list());

        return "showUpdateVoie";
    }

    // @Valid @ModelAttribute User user

    @RequestMapping(path = "/voie", method = RequestMethod.POST)
    public String addVoie(
        @RequestParam("height") float height,
        @RequestParam("secteurfk") int secteurFK,
        Model model) throws BeanException
    {
        Sector secteur = secteurDAO.get(secteurFK);

        Voie voie = new Voie();

        voie.setHeight(height);
        voie.setSecteurFK(secteur);

        voieDAO.add(voie);

        model.addAttribute("title", "Voie ajoutée");

        model.addAttribute("height", height);

        return "addVoie";
    }

    @RequestMapping(path = "/voie/update/{id}", method = RequestMethod.POST)
    public String updateVoie(
        @PathVariable(value = "id") final int id,
        @RequestParam("height") float height,
        @RequestParam("secteurfk") int secteurfk,
        Model model) throws Exception
    {
        Sector secteur = secteurDAO.get(secteurfk);

        Voie voie = voieDAO.get(id);

        voie.setHeight(height);
        voie.setSecteurFK(secteur);

        voieDAO.update(voie);

        model.addAttribute("title", "Voie modifiée");

        model.addAttribute("message", "Voie modifiée avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("voie", voie);

        model.addAttribute("voies", voieDAO.list());

        return "showUpdateVoie";
    }

    @RequestMapping(path = "/voie/delete/{id}", method = RequestMethod.GET)
    public String deleteVoie(@PathVariable(value = "id") final int id, Model model)
    {
        voieDAO.delete(id);

        model.addAttribute("title", "Voie supprimée");

        model.addAttribute("id", id);

        return "deleteVoie";
    }
}