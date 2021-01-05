package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.beans.Address;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.AddressDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

@Controller
public class SearchController
{
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String showAddresses(Model model) throws Exception
    {
        model.addAttribute("title", "Recherche");

        return "search";
    }
}