package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.morlotti.escalade.EmailSingleton;
import xyz.morlotti.escalade.models.BeanException;
import xyz.morlotti.escalade.models.beans.Booking;
import xyz.morlotti.escalade.models.beans.Topo;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.BookingDAO;
import xyz.morlotti.escalade.models.daos.TopoDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

import javax.servlet.http.HttpSession;

@Controller
public class TopoController
{
    @Autowired
    private TopoDAO topoDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BookingDAO bookingDAO;

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

        model.addAttribute("parentUser", parentUser);
        model.addAttribute("users", userDAO.list());

        return "showTopos";
    }

    @RequestMapping(path = "/topo/{id}", method = RequestMethod.GET)
    public String showTopo(
        @PathVariable(value = "id") final int id,
        @RequestParam(name = "isavailable", required = false) Boolean isAvailable,
        @RequestParam(name = "bookuserfk", required = false) Integer bookUserFK,
        HttpSession httpSession,
        Model model) throws Exception
    {
        model.addAttribute("title", "Topo");

        Topo topo = topoDAO.get(id);

        if(bookUserFK == null)
        {
            User user = (User) httpSession.getAttribute ("currentUser");

            bookUserFK = user.getId();
        }

        if(isAvailable != null)
        {
            topo.setIsAvailable(isAvailable);
        }

        model.addAttribute("topo", topo);

        model.addAttribute("users", userDAO.list());
        model.addAttribute("bookUserFK", bookUserFK);

        model.addAttribute("bookings", bookingDAO.list(id));

        return "showUpdateTopo";
    }

    @RequestMapping(path = "/topo", method = RequestMethod.POST)
    public String addTopo(
        @RequestParam("name") String name,
        @RequestParam("description") String description,
        @RequestParam("city") String city,
        @RequestParam("postalcode") String postalCode,
        @RequestParam("releasedate") String releaseDate,
        @RequestParam("isavailable") boolean isAvailable,
        @RequestParam("bookuserfk") int bookUserFK,
        @RequestParam("userfk") int userFK,
        Model model) throws Exception
    {
        User user = userDAO.get(userFK);
        User bookUser = userDAO.get(bookUserFK);

        Topo topo = new Topo();

        topo.setName(name);
        topo.setDescription(description);
        topo.setCity(city);
        topo.setPostalCode(postalCode);
        topo.setReleaseDate(releaseDate);
        topo.setIsAvailable(isAvailable);
        topo.setUserFK(user);

        topoDAO.add(topo);

        /**/

        book(isAvailable, bookUser, topo);

        /**/

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
        @RequestParam("bookuserfk") int bookUserFK,
        @RequestParam("userfk") int userFK,
        Model model) throws Exception
    {
        User user = userDAO.get(userFK);
        User bookUser = userDAO.get(bookUserFK);

        Topo topo = topoDAO.get(id);

        topo.setName(name);
        topo.setDescription(description);
        topo.setCity(city);
        topo.setPostalCode(postalCode);
        topo.setReleaseDate(releaseDate);
        topo.setIsAvailable(isAvailable);
        topo.setUserFK(user);

        topoDAO.update(topo);

        /**/

        book(isAvailable, bookUser, topo);

        /**/

        model.addAttribute("title", "Topo modifié");

        model.addAttribute("message", "Topo modifié avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("topo", topo);

        model.addAttribute("users", userDAO.list());
        model.addAttribute("bookUserFK", bookUserFK);

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

    @RequestMapping(path = "/topo/book/{id}", method = RequestMethod.GET)
    public String bookTopo(
        @PathVariable(value = "id") final int id,
        @RequestParam(name = "user", required = false) Integer parentUser,
        HttpSession httpSession,
        Model model) throws Exception
    {
        model.addAttribute("title", "Topo");

        User user = (User) httpSession.getAttribute ("currentUser");

        Topo topo = topoDAO.get(id);

        EmailSingleton.sendMessage(
            user.getEmail(),
            topo.getUserFK().getEmail(),
            "",
            "Demande réservation du topo " + topo.getName(),
            "Bonjour,\nL'utilisateur " + user.getLogin() + " souhaite réserver le topo " + topo.getName() + ".\n" +
            "Pour donner votre accord, veuillez cliquer ici : http://localhost:8080/Escalade/topo/" + topo.getId() + "?isavailable=0&bookuserfk=" + user.getId() + ".\n" +
            "Cordialement,\n" + "Les Amis de l'escalade"
        );

        /**/

        model.addAttribute("message", "Demande de réservation du topo " + topo.getName() + " envoyée !");

        model.addAttribute("message_type", "success");

        return showTopos(parentUser, model);
    }

    @RequestMapping(path = "/topo/notbook/{id}", method = RequestMethod.GET)
    public String notBookTopo(
        @PathVariable(value = "id") final int id,
        @RequestParam(name = "user", required = false) Integer parentUser,
        HttpSession httpSession,
        Model model) throws Exception
    {
        model.addAttribute("title", "Topo");

        User user = (User) httpSession.getAttribute ("currentUser");

        Topo topo = topoDAO.get(id);

        EmailSingleton.sendMessage(
            user.getEmail(),
            topo.getUserFK().getEmail(),
            "",
            "Demande réservation du topo " + topo.getName() + " refusée",
            "Bonjour,\nVotre demande demande de réservation du topo " + topo.getName() + " a été refusée.\n" +
            "Cordialement,\n" + "Les Amis de l'escalade"
        );

        /**/

        model.addAttribute("message", "Demande de réservation du topo " + topo.getName() + " refusée !");

        model.addAttribute("message_type", "danger");

        return showTopos(parentUser, model);
    }

    private void book(boolean isAvailable, User user, Topo topo) throws Exception
    {
        if(!isAvailable)
        {
            Booking booking = new Booking();

            booking.setUserFK(user);
            booking.setTopoFK(topo);

            bookingDAO.add(booking);

            EmailSingleton.sendMessage(
                user.getEmail(),
                topo.getUserFK().getEmail(),
                "",
                "Demande réservation du topo " + topo.getName() + " acceptée !",
                "Bonjour,\nVotre demande demande de réservation du topo " + topo.getName() + " a été acceptée par " + user.getLogin() + ".\n" +
                "Cordialement,\n" + "Les Amis de l'escalade"
            );
        }
    }
}