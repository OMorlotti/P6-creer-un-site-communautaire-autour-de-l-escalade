package xyz.morlotti.escalade.controllers;

import javax.validation.*;

import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.morlotti.escalade.beans.User;
import xyz.morlotti.escalade.daos.UserDAO;

@Controller
public class UserController
{
	@Autowired
	private UserDAO m_userDAO;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public String showUsers(Model model) throws Exception
	{
		model.addAttribute("title", "Users");

		model.addAttribute("users", m_userDAO.list());

		return "showUsers";
	}

	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public String showUsers(@PathVariable(value = "id") final int id, Model model)
	{
		model.addAttribute("title", "Users");

		model.addAttribute("user", m_userDAO.get(id));

		return "showUser";
	}

	// @Valid @ModelAttribute User user
}
