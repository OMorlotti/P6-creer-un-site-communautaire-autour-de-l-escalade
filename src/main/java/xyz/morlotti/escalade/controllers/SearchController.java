package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.beans.Address;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.AddressDAO;
import xyz.morlotti.escalade.models.daos.CotationDAO;
import xyz.morlotti.escalade.models.daos.SpotDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

import java.util.List;

@Controller
public class SearchController
{
    @Autowired
    private SpotDAO spotDAO;

    @Autowired
    private CotationDAO cotationDAO;

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String searchSpot(Model model) throws Exception
    {
        model.addAttribute("title", "Recherche");

        model.addAttribute("cotations", cotationDAO.list());

        return "search";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String searchSpot(
        @RequestParam(name = "departement", required = false) String departement,
        @RequestParam(name = "nbofsectors", required = false) Integer nbofsectors,
        @RequestParam(name = "nbofvoies", required = false) Integer nbofvoies,
        @RequestParam(name = "cotation", required = false) String cotation,
        Model model) throws Exception
    {
        model.addAttribute("title", "Recherche");

        model.addAttribute("cotations", cotationDAO.list());

        model.addAttribute("spots", spotDAO.get(departement, nbofsectors, nbofvoies, cotation));

        return "search";
    }
}