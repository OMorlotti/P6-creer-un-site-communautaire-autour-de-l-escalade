package xyz.morlotti.escalade.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.annotation.SessionScope;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.UserDAO;

import javax.persistence.NoResultException;

@Controller
public class AuthController extends AbstractController
{
    @Autowired
    private UserDAO userDAO;

    /*----------------------------------------------------------------------------------------------------------------*/

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginStep1(Model model) throws Exception
    {
        model.addAttribute("title", "Authentification");

        return "loginStep1";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginStep2(
        @RequestParam("login") String login,
        @RequestParam("password") String password,
        Model model) throws Exception
    {
        try
        {
            User user = userDAO.get(login, password);

            model.addAttribute("currentUser", user);

            return "loginStep2";
        }
        catch(NoResultException e)
        {
            model.addAttribute("message_type", "danger");
            model.addAttribute("message", "Login ou mot de passe incorrect");

            return "loginStep1";
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(Model model) throws Exception
    {
        model.addAttribute("title", "Authentification");

        User currentUser = (User) model.getAttribute("currentUser");

        currentUser.initGuest();

        return "logout";
    }
}
