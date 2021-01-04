package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.morlotti.escalade.models.beans.Cotation;
import xyz.morlotti.escalade.models.beans.Length;
import xyz.morlotti.escalade.models.beans.Voie;
import xyz.morlotti.escalade.models.daos.CotationDAO;
import xyz.morlotti.escalade.models.daos.LengthDAO;
import xyz.morlotti.escalade.models.daos.VoieDAO;

@Controller
public class LengthController
{
    @Autowired
    private LengthDAO lengthDAO;

    @Autowired
    private VoieDAO voieDAO;

    @Autowired
    private CotationDAO cotationDAO;

    @RequestMapping(path = "/longueurs", method = RequestMethod.GET)
    public String showLengths(
        @RequestParam(name = "voie", required = false) Integer parentVoie, // Le post parent est passé dans l'url en ajoutan ?spot=<id>, il est facultatif et dans ce cas, on aura null dans parentSpot
        Model model) throws Exception
    {
        model.addAttribute("title", "Longueurs");

        if(parentVoie == null) {
            model.addAttribute("lengths", lengthDAO.list());
        }
        else {
            model.addAttribute("lengths", lengthDAO.list(parentVoie));
        }

        model.addAttribute("parentVoieId", parentVoie);
        model.addAttribute("voies", voieDAO.list());

        model.addAttribute("cotations", cotationDAO.list());

        return "showLengths";
    }

    @RequestMapping(path = "/longueur/{id}", method = RequestMethod.GET)
    public String showLength(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "Longueur");

        model.addAttribute("length", lengthDAO.get(id));

        model.addAttribute("voies", voieDAO.list());

        model.addAttribute("cotations", cotationDAO.list());

        return "showUpdateLength";
    }

    // @Valid @ModelAttribute User user

    @RequestMapping(path = "/longueur", method = RequestMethod.POST)
    public String addLength(
        @RequestParam("voiefk") int voieFK,
        @RequestParam("cotationfk") int cotationFK,
        @RequestParam("numberofspit") int numberOfSpit,
        Model model) throws Exception
    {
        Voie voie = voieDAO.get(voieFK);
        Cotation cotation = cotationDAO.get(cotationFK);

        Length length = new Length();

        length.setVoieFK(voie);
        length.setCotationFK(cotation);
        length.setNumberOfSpits(numberOfSpit);

        lengthDAO.add(length);

        /**/

        model.addAttribute("message", "Voie ajoutée avec succès !");

        model.addAttribute("message_type", "success");

        return showLengths(voieFK, model);
    }

    @RequestMapping(path = "/longueur/update/{id}", method = RequestMethod.POST)
    public String updateLength(
        @PathVariable(value = "id") final int id,
        @RequestParam("voiefk") int voieFK,
        @RequestParam("cotationfk") int cotationFK,
        @RequestParam("numberofspit") int numberOfSpit,
        Model model) throws Exception
    {
        Voie voie = voieDAO.get(voieFK);
        Cotation cotation = cotationDAO.get(cotationFK);

        int parentVoieId = voie.getId();

        Length length = lengthDAO.get(id);

        length.setVoieFK(voie);
        length.setCotationFK(cotation);
        length.setNumberOfSpits(numberOfSpit);

        lengthDAO.update(length);

        /**/

        model.addAttribute("message", "Voie " + id + " modifiée avec succès !");

        model.addAttribute("message_type", "success");

        return showLengths(parentVoieId, model);
    }

    @RequestMapping(path = "/longueur/delete/{id}", method = RequestMethod.GET)
    public String deleteLength(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        Length length = lengthDAO.get(id);

        int parentVoieId = length.getVoieFK().getId();

        lengthDAO.delete(id);

        /**/

        model.addAttribute("message", "Voie " + id + " supprimé avec succès !");

        model.addAttribute("message_type", "success");

        return showLengths(parentVoieId, model);
    }
}