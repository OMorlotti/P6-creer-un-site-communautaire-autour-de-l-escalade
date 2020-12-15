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
import xyz.morlotti.escalade.models.daos.CotationDAO;
import xyz.morlotti.escalade.models.daos.LengthDAO;
import xyz.morlotti.escalade.models.daos.VoieDAO;

@Controller
public class CotationController
{
    @Autowired
    private LengthDAO lengthDAO;

    @Autowired
    private VoieDAO voieDAO;

    @Autowired
    private CotationDAO cotationDAO;

    @RequestMapping(path = "/cotations", method = RequestMethod.GET)
    public String showCotations(Model model) throws Exception
    {
        model.addAttribute("title", "Cotations");

        model.addAttribute("cotations", cotationDAO.list());

        model.addAttribute("cotations", cotationDAO.list());

        return "showCotations";
    }

    @RequestMapping(path = "/cotation/{id}", method = RequestMethod.GET)
    public String showCotation(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "Cotation");

        model.addAttribute("cotation", cotationDAO.get(id));

        model.addAttribute("cotations", voieDAO.list());

        return "showUpdateCotation";
    }

    // @Valid @ModelAttribute User user

    @RequestMapping(path = "/cotation", method = RequestMethod.POST)
    public String addCotation(
        @RequestParam("name") String name,
        Model model) throws BeanException
    {
        Cotation cotation = new Cotation();

        cotation.setName(name);


        cotationDAO.add(name);

        model.addAttribute("title", "Cotation ajoutée");

        return "addLength";
    }

    @RequestMapping(path = "/cotation/update/{id}", method = RequestMethod.POST)
    public String updateCotation(
        @PathVariable(value = "id") final int id,
        @RequestParam("name") String name,
        Model model) throws Exception
    {
        Cotation cotation = cotationDAO.get(cotationFK);

        Cotation cotation = cotationDAO.get(id);

        cotation.setName(name);


        cotationDAO.update(name);

        model.addAttribute("title", "Cotation modifiée");

        model.addAttribute("message", "Cotation modifiée avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("cotation", cotation);

        model.addAttribute("cotations", cotationDAO.list());

        return "showUpdateCotation";
    }

    @RequestMapping(path = "/cotation/delete/{id}", method = RequestMethod.GET)
    public String deleteCotation(@PathVariable(value = "id") final int id, Model model)
    {
        cotationDAO.delete(id);

        model.addAttribute("title", "Cotation supprimée");

        model.addAttribute("id", id);

        return "deleteCotation";
    }
}