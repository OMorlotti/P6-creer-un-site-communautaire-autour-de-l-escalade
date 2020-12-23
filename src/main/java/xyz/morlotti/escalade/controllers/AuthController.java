package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.UserDAO;

import javax.persistence.NoResultException;

@Controller
@SessionAttributes(value = "currentUser", types = {User.class})
public class AuthController
{
    @Autowired
    private UserDAO userDAO;

    private void setGestUserInfo(User user)
    {
        user.setId(0);
        user.setFirstName("guest");
        user.setLastName("guest");
        user.setLogin("guest");
        user.setPassword("guest");
        user.setRole(User.Role.GUEST);
    }

    @ModelAttribute
    public void addAttributes(Model model)
    {
        User user = new User();

        setGestUserInfo(user);

        model.addAttribute("currentUser", user);
    }

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

        setGestUserInfo(currentUser);

        return "logout";
    }
}