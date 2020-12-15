package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.morlotti.escalade.models.BeanException;
import xyz.morlotti.escalade.models.beans.Cotation;
import xyz.morlotti.escalade.models.beans.Length;
import xyz.morlotti.escalade.models.beans.Voie;
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
    public String showLengths(Model model) throws Exception
    {
        model.addAttribute("title", "Longueurs");

        model.addAttribute("longueurs", lengthDAO.list());

        model.addAttribute("voies", voieDAO.list());

        return "showLengths";
    }

    @RequestMapping(path = "/longueur/{id}", method = RequestMethod.GET)
    public String showLength(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "Longueur");

        model.addAttribute("longueur", lengthDAO.get(id));

        model.addAttribute("voies", voieDAO.list());

        return "showUpdateLength";
    }

    // @Valid @ModelAttribute User user

    @RequestMapping(path = "/longueur", method = RequestMethod.POST)
    public String addLength(
        @RequestParam("voiefk") int voieFK,
        @RequestParam("cotationfk") int cotationFK,
        @RequestParam("numberofspit") int numberOfSpit,
        Model model) throws BeanException
    {
        Length length = new Length();

        length.setVoieFK(voieFK);
        length.setCotationFK(cotationFK);
        length.setNumberOfSpit(numberOfSpit);

        lengthDAO.add(length);

        model.addAttribute("title", "Longueur ajoutée");

        model.addAttribute("voie", voieFK);

        model.addAttribute("cotation", cotationFK);

        model.addAttribute("numberOfSpit", numberOfSpit);

        return "addLength";
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

        Length length = lengthDAO.get(id);

        length.setVoieFK(voieFK);
        length.setCotationFK(cotationFK);
        length.setNumberOfSpit(numberOfSpit);

        lengthDAO.update(length);

        model.addAttribute("title", "Longueur modifiée");

        model.addAttribute("message", "Longueur modifiée avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("voie", voie);

        model.addAttribute("voies", voieDAO.list());

        return "showUpdateVoie";
    }

    @RequestMapping(path = "/longueur/delete/{id}", method = RequestMethod.GET)
    public String deleteLength(@PathVariable(value = "id") final int id, Model model)
    {
        lengthDAO.delete(id);

        model.addAttribute("title", "Longueur supprimée");

        model.addAttribute("id", id);

        return "deleteLength";
    }
}