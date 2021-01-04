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
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.TopoDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

@Controller
public class TopoController
{
    @Autowired
    private TopoDAO topoDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = "/topos", method = RequestMethod.GET)
    public String showTopos(
        @RequestParam(name = "user", required = false) Integer parentUser,
        Model model) throws Exception
    {
        model.addAttribute("title", "Topos");

        if(parentUser != null) {
            model.addAttribute("topos", topoDAO.list(parentUser));
        }
        else {
            model.addAttribute("topos", topoDAO.list());
        }

        model.addAttribute("users", userDAO.list());

        return "showTopos";
    }

    @RequestMapping(path = "/topo/{id}", method = RequestMethod.GET)
    public String showTopo(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "Topo");

        model.addAttribute("topo", topoDAO.get(id));

        model.addAttribute("users", userDAO.list());

        return "showUpdateTopo";
    }

    // @Valid @ModelAttribute User user

    @RequestMapping(path = "/topo", method = RequestMethod.POST)
    public String addTopo(
        @RequestParam("name") String name,
        @RequestParam("description") String description,
        @RequestParam("city") String city,
        @RequestParam("postalcode") String postalCode,
        @RequestParam("releasedate") String releaseDate,
        @RequestParam("isavailable") boolean isAvailable,
        @RequestParam("userfk") int userFK,
        Model model) throws BeanException
    {
        User user = userDAO.get(userFK);

        Topo topo = new Topo();

        topo.setName(name);
        topo.setDescription(description);
        topo.setCity(city);
        topo.setPostalCode(postalCode);
        topo.setReleaseDate(releaseDate);
        topo.setIsAvailable(isAvailable);
        topo.setUserFK(user);

        topoDAO.add(topo);

        model.addAttribute("title", "Topo ajouté");

        model.addAttribute("name", name);

        return "addTopo";
    }

    @RequestMapping(path = "/topo/update/{id}", method = RequestMethod.POST)
    public String updateTopo(
        @PathVariable(value = "id") final int id,
        @RequestParam("name") String name,
        @RequestParam("description") String description,
        @RequestParam("city") String city,
        @RequestParam("postalcode") String postalCode,
        @RequestParam("releasedate") String releaseDate,
        @RequestParam("isavailable") boolean isAvailable,
        @RequestParam("userfk") int userFK,
        Model model) throws Exception
    {
        User user = userDAO.get(userFK);

        Topo topo = topoDAO.get(id);

        topo.setName(name);
        topo.setDescription(description);
        topo.setCity(city);
        topo.setPostalCode(postalCode);
        topo.setReleaseDate(releaseDate);
        topo.setIsAvailable(isAvailable);
        topo.setUserFK(user);

        topoDAO.update(topo);

        model.addAttribute("title", "Topo modifié");

        model.addAttribute("message", "Topo modifié avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("topo", topo);

        model.addAttribute("users", userDAO.list());

        return "showUpdateTopo";
    }

    @RequestMapping(path = "/topo/delete/{id}", method = RequestMethod.GET)
    public String deleteTopo(@PathVariable(value = "id") final int id, Model model)
    {
        topoDAO.delete(id);

        model.addAttribute("title", "Topo supprimé");

        model.addAttribute("id", id);

        return "deleteTopo";
    }
}