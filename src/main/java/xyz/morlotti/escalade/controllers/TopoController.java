package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.morlotti.escalade.models.BeanException;
import xyz.morlotti.escalade.models.beans.Topo;
import xyz.morlotti.escalade.models.daos.TopoDAO;


@Controller
public class TopoController
{
    @Autowired
    private TopoDAO userDAO;

    @RequestMapping(path = "/topos", method = RequestMethod.GET)
    public String showTopos(Model model) throws Exception
    {
        model.addAttribute("title", "Topos");

        model.addAttribute("topos", TopoDAO.list());

        return "showTopos";
    }

    @RequestMapping(path = "/topo/{id}", method = RequestMethod.GET)
    public String showTopo(@PathVariable(value = "id") final int id, Model model)
    {
        model.addAttribute("title", "Topo");

        model.addAttribute("topo", TopoDAO.get(id));

        return "showTopo";
    }

    // @Valid @ModelAttribute User user

    @RequestMapping(path = "/topo", method = RequestMethod.POST)
    public String addTopo(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("city") String city,
            @RequestParam("postalCode") String postalCode,
            @RequestParam("releaseDate") String releaseDate,
            @RequestParam("isAvailable") boolean isAvailable,
            @RequestParam("userFK") String userFK,
            Model model) throws BeanException
    {
        Topo topo = new Topo();

        topo.setName(name);
        topo.setDescription(description);
        topo.setCity(city);
        topo.setPostalCode(postalCode);
        topo.setReleaseDate(releaseDate);
        topo.isAvailable;
        topo.setUserFK(userFK);

        TopoDAO.add(topo);

        model.addAttribute("title", "Topo ajouté");

        return "addTopo";
    }

    @RequestMapping(path = "/topo/update/{id}", method = RequestMethod.POST)
    public String updateTopo(
            @PathVariable(value = "id") final int id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("city") String city,
            @RequestParam("postalCode") String postalCode,
            @RequestParam("releaseDate") String releaseDate,
            @RequestParam("isAvailable") boolean isAvailable,
            @RequestParam("userFK") String userFK,
            Model model) throws BeanException
    {
        Topo topo = TopoDAO.get(id);

        topo.setName(name);
        topo.setDescription(description);
        topo.setCity(city);
        topo.setPostalCode(postalCode);
        topo.setReleaseDate(releaseDate);
        topo.isAvailable();
        topo.setUserFK(userFK);


        TopoDAO.update(userFK);

        model.addAttribute("title", "Topo modifié");

        model.addAttribute("message", "Topo modifié avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("user", userFK);

        return "showTopo";
    }

    @RequestMapping(path = "/topo/delete/{id}", method = RequestMethod.GET)
    public String deleteTopo(@PathVariable(value = "id") final int id, Model model)
    {
        TopoDAO.delete(id);

        model.addAttribute("title", "Topo supprimé");

        model.addAttribute("id", id);

        return "deleteTopo";
    }
}