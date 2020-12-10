package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.BeanException;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.daos.SpotDAO;


@Controller
public class SpotController
{
    @Autowired
    private SpotDAO spotDAO;

    @RequestMapping(path = "/spots", method = RequestMethod.GET)
    public String showSpots(Model model) throws Exception
    {
        model.addAttribute("title", "Spots");

        model.addAttribute("spots", spotDAO.list());

        return "showSpots";
    }

    @RequestMapping(path = "/spot/{id}", method = RequestMethod.GET)
    public String showSpot(@PathVariable(value = "id") final int id, Model model)
    {
        model.addAttribute("title", "spot");

        model.addAttribute("spot", spotDAO.get(id));

        return "showSpot";
    }

    // @Valid @ModelAttribute Secteur secteur

    @RequestMapping(path = "/spot", method = RequestMethod.POST)
    public String addSpot(
            @RequestParam("name") String name,
            @RequestParam("userFK") String userFK,
            @RequestParam("topoFK") String topoFK,
            @RequestParam("departement") String departement,
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            @RequestParam("isOfficial") boolean isOfficial,

            Model model) throws BeanException

    {
        Spot spot = new Spot();

        spot.setName(name);
        spot.setUserFK(userFK);
        spot.setTopoFK(topoFK);
        spot.setDepartement(departement);
        spot.setLatitude(latitude);
        spot.setLongitude(longitude);
        spot.isOfficial();


        spotDAO.add(spot);

        model.addAttribute("title", "Spot ajouté");

        return "addSpot";
    }

    @RequestMapping(path = "/spot/update/{id}", method = RequestMethod.POST)
    public String updateSpot(
            @PathVariable(value = "id") final int id,
            @RequestParam("name") String name,
            @RequestParam("userFK") String userFK,
            @RequestParam("topoFK") String topoFK,
            @RequestParam("departement") String departement,
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            @RequestParam("isOfficial") boolean isOfficial,
            Model model) throws BeanException

    {
        Spot spot = spotDAO.get(id);

        spot.setName(name);
        spot.setSpotFK(spotFK);

        spotDAO.update(spot);

        model.addAttribute("title", "Spot modifié");

        model.addAttribute("message", "Spot modifié avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("spot", spot);

        return "showSpot";
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