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
public class AddressController extends AbstractController
{
    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = "/addresses", method = RequestMethod.GET)
    public String showAddresses(
        @RequestParam(name = "user", required = false) Integer parentUser,
        Model model) throws Exception
    {
        model.addAttribute("title", "Adresses");

        if(parentUser != null) {
            model.addAttribute("addresses", addressDAO.list(parentUser));
        }
        else {
            model.addAttribute("addresses", addressDAO.list());
        }

        model.addAttribute("users", userDAO.list());

        return "showAddresses";
    }

    @RequestMapping(path = "/address/{id}", method = RequestMethod.GET)
    public String showAddress(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "adresse");

        model.addAttribute("address", addressDAO.get(id));

        model.addAttribute("users", userDAO.list());

        return "showUpdateAddress";
    }

    // @Valid @ModelAttribute Secteur secteur

    @RequestMapping(path = "/address", method = RequestMethod.POST)
    public String addAddress(
        @RequestParam("userfk") int userFK,
        @RequestParam("street") String street,
        @RequestParam("streetname") String streetName,
        @RequestParam("postalcode") String postalCode,
        @RequestParam("city") String city,
        @RequestParam("country") String country,
        Model model)
    {
        User user = userDAO.get(userFK);

        Address address = new Address();

        address.setUserFK(user);
        address.setStreet(street);
        address.setStreetName(streetName);
        address.setPostalCode(postalCode);
        address.setCity(city);
        address.setCountry(country);

        addressDAO.add(address);

        model.addAttribute("title", "Adresse ajoutée");

        return "addAddress";
    }

    @RequestMapping(path = "/address/update/{id}", method = RequestMethod.POST)
    public String updateAddress(
        @PathVariable(value = "id") final int id,
        @RequestParam("userfk") int userFK,
        @RequestParam("street") String street,
        @RequestParam("streetname") String streetName,
        @RequestParam("postalcode") String postalCode,
        @RequestParam("city") String city,
        @RequestParam("country") String country,
        Model model) throws Exception
    {
        User user = userDAO.get(userFK);

        Address address = addressDAO.get(id);

        address.setUserFK(user);
        address.setStreet(street);
        address.setStreetName(streetName);
        address.setPostalCode(postalCode);
        address.setCity(city);
        address.setCountry(country);

        addressDAO.update(address);

        model.addAttribute("title", "Adresse modifiée");

        model.addAttribute("message", "Adresse modifiée avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("address", address);

        model.addAttribute("users", userDAO.list());

        return "showUpdateAddress";
    }

    @RequestMapping(path = "/address/delete/{id}", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable(value = "id") final int id, Model model)
    {
        addressDAO.delete(id);

        model.addAttribute("title", "Adresse supprimée");

        model.addAttribute("id", id);

        return "deleteAddress";
    }
}