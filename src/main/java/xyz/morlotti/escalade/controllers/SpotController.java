package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.beans.Topo;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.SpotDAO;
import xyz.morlotti.escalade.models.daos.TopoDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

@Controller
public class SpotController
{
    @Autowired
    private SpotDAO spotDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TopoDAO topoDAO;

    @RequestMapping(path = "/spots", method = RequestMethod.GET)
    public String showSpots(
        @RequestParam(name = "user", required = false) Integer parentUser,
        Model model) throws Exception
    {
        model.addAttribute("title", "Spots");

        if(parentUser != null) {
            model.addAttribute("spots", spotDAO.list(parentUser));
        }
        else {
            model.addAttribute("spots", spotDAO.list());
        }

        model.addAttribute("users", userDAO.list());

        model.addAttribute("topos", topoDAO.list());

        return "showSpots";
    }

    @RequestMapping(path = "/spot/{id}", method = RequestMethod.GET)
    public String showSpot(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "spot");

        model.addAttribute("spot", spotDAO.get(id));

        model.addAttribute("users", userDAO.list());

        model.addAttribute("topos", topoDAO.list());

        return "showUpdateSpot";
    }

    // @Valid @ModelAttribute Secteur secteur

    @RequestMapping(path = "/spot", method = RequestMethod.POST)
    public String addSpot(
        @RequestParam("name") String name,
        @RequestParam("userfk") int userFK,
        @RequestParam("topofk") int topoFK,
        @RequestParam("departement") String departement,
        @RequestParam("latitude") String latitude,
        @RequestParam("longitude") String longitude,
        @RequestParam("isofficial") boolean isOfficial,
        Model model)
    {
        User user = userDAO.get(userFK);
        Topo topo = topoDAO.get(topoFK);

        Spot spot = new Spot();

        spot.setName(name);
        spot.setUserFK(user);
        spot.setTopoFK(topo);
        spot.setDepartement(departement);
        spot.setLatitude(latitude);
        spot.setLongitude(longitude);
        spot.setIsOfficial(isOfficial);

        spotDAO.add(spot);

        model.addAttribute("title", "Spot ajouté");

        return "addSpot";
    }

    @RequestMapping(path = "/spot/update/{id}", method = RequestMethod.POST)
    public String updateSpot(
        @PathVariable(value = "id") final int id,
        @RequestParam("name") String name,
        @RequestParam("userfk") int userFK,
        @RequestParam("topofk") int topoFK,
        @RequestParam("departement") String departement,
        @RequestParam("latitude") String latitude,
        @RequestParam("longitude") String longitude,
        @RequestParam("isofficial") boolean isOfficial,
        Model model) throws Exception
    {
        User user = userDAO.get(userFK);
        Topo topo = topoDAO.get(topoFK);

        Spot spot = spotDAO.get(id);

        spot.setName(name);
        spot.setUserFK(user);
        spot.setTopoFK(topo);
        spot.setDepartement(departement);
        spot.setLatitude(latitude);
        spot.setLongitude(longitude);
        spot.setIsOfficial(isOfficial);

        spotDAO.update(spot);

        model.addAttribute("title", "Spot modifié");

        model.addAttribute("message", "Spot modifié avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("spot", spot);

        model.addAttribute("users", userDAO.list());

        model.addAttribute("topos", topoDAO.list());

        return "showUpdateSpot";
    }

    @RequestMapping(path = "/spot/delete/{id}", method = RequestMethod.GET)
    public String deleteSpot(@PathVariable(value = "id") final int id, Model model)
    {
        spotDAO.delete(id);

        model.addAttribute("title", "Spot supprimé");

        model.addAttribute("id", id);

        return "deleteSpot";
    }
}