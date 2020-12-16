package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.beans.Address;
import xyz.morlotti.escalade.models.beans.Length;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.AddressDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

@Controller
public class AddressController
{
    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = "/adresses", method = RequestMethod.GET)
    public String showAddresses(Model model) throws Exception
    {
        model.addAttribute("title", "Adresses");

        model.addAttribute("adresses", addressDAO.list());

        model.addAttribute("users", userDAO.list());

        return "showAdresses";
    }

    @RequestMapping(path = "/adresse/{id}", method = RequestMethod.GET)
    public String showAddress(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "adresse");

        model.addAttribute("user", userDAO.get(id));

        return "showUpdateAddress";
    }

    // @Valid @ModelAttribute Secteur secteur

    @RequestMapping(path = "/adresse", method = RequestMethod.POST)
    public String addAddress(
        @RequestParam("userfk") int userFK,
        @RequestParam("street") String street,
        @RequestParam("streetname") String streetname,
        @RequestParam("postalcode") String postalcode,
        @RequestParam("city") String city,
        @RequestParam("country") String country,
        Model model)
    {
        User user = userDAO.get(userFK);

        Address address = new Address();

        address.setUserFK(user);
        address.setStreet(street);
        address.setStreetName(street);
        address.setPostalCode(postalcode);
        address.setCity(city);
        address.setCountry(country);

        addressDAO.add(address);

        model.addAttribute("title", "Adresse ajoutée");

        return "addAddress";
    }

    @RequestMapping(path = "/adresse/update/{id}", method = RequestMethod.POST)
    public String updateAddress(
        @PathVariable(value = "id") final int id,
        @RequestParam("userfk") int userFK,
        @RequestParam("street") String street,
        @RequestParam("streetname") String streetName,
        @RequestParam("postalcode") String postalCode,
        @RequestParam("city") String city,
        @RequestParam("longitude") String longitude,
        @RequestParam("country") String country,
        Model model) throws Exception
    {
        User user = userDAO.get(userFK);

        Address address = addressDAO.get(id);

        address.setUserFK(user);
        address.setStreet(street);
        address.setStreetName(street);
        address.setPostalCode(postalCode);
        address.setCity(city);
        address.setCountry(country);

        addressDAO.update(address);

        model.addAttribute("title", "Adresse modifiée");

        model.addAttribute("message", "Adresse modifiée avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("users", userDAO.list());


        return "showUpdateAddress";
    }

    @RequestMapping(path = "/adresse/delete/{id}", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable(value = "id") final int id, Model model)
    {
        addressDAO.delete(id);

        model.addAttribute("title", "Adresse supprimée");

        model.addAttribute("id", id);

        return "deleteAddress";
    }
}