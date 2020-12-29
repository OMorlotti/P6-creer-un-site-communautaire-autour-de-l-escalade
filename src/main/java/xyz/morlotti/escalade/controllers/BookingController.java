package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.beans.Booking;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.beans.Topo;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.BookingDAO;
import xyz.morlotti.escalade.models.daos.SpotDAO;
import xyz.morlotti.escalade.models.daos.TopoDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

@Controller
public class BookingController
{
    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TopoDAO topoDAO;

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public String showBookings(Model model) throws Exception
    {
        model.addAttribute("title", "Reservations");

        model.addAttribute("reservations", bookingDAO.list());

        model.addAttribute("users", userDAO.list());

        model.addAttribute("topos", topoDAO.list());

        return "showBookings";
    }

    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.GET)
    public String showBooking(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "spot");

        model.addAttribute("reservation", bookingDAO.get(id));

        model.addAttribute("users", userDAO.list());

        model.addAttribute("topos", topoDAO.list());

        return "showUpdateBooking";
    }

    // @Valid @ModelAttribute Secteur secteur

    @RequestMapping(path = "/reservation", method = RequestMethod.POST)
    public String addBooking(
        @RequestParam("userfk") int userFK,
        @RequestParam("topofk") int topoFK,
        @RequestParam("isreserved") boolean isReserved,
        Model model)
    {
        User user = userDAO.get(userFK);
        Topo topo = topoDAO.get(topoFK);

        Booking booking = new Booking();

        booking.setUserFK(user);
        booking.setTopoFK(topo);
        booking.setIsReserved(isReserved);

        bookingDAO.add(booking);

        model.addAttribute("title", "Réservation ajoutée");

        return "addBooking";
    }

    @RequestMapping(path = "/reservation/update/{id}", method = RequestMethod.POST)
    public String updateBooking(
        @PathVariable(value = "id") final int id,
        @RequestParam("userfk") int userFK,
        @RequestParam("topofk") int topoFK,
        @RequestParam("isreserved") boolean isReserved,
        Model model) throws Exception
    {
        User user = userDAO.get(userFK);
        Topo topo = topoDAO.get(topoFK);

        Booking booking = bookingDAO.get(id);

        booking.setUserFK(user);
        booking.setTopoFK(topo);
        booking.setIsReserved(isReserved);

        bookingDAO.update(booking);

        model.addAttribute("title", "Réservation modifiée");

        model.addAttribute("message", "Réservation modifiée avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("reservation", booking);

        model.addAttribute("users", userDAO.list());

        model.addAttribute("topos", topoDAO.list());

        return "showUpdateBooking";
    }

    @RequestMapping(path = "/reservation/delete/{id}", method = RequestMethod.GET)
    public String deleteBooking(@PathVariable(value = "id") final int id, Model model)
    {
        bookingDAO.delete(id);

        model.addAttribute("title", "Réservation supprimée");

        model.addAttribute("id", id);

        return "deleteBooking";
    }
}