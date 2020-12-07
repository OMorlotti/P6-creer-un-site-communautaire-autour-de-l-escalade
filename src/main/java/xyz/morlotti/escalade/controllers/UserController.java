package xyz.morlotti.escalade.controllers;

import javax.validation.*;

import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import xyz.morlotti.escalade.beans.*;

@Controller
public class UserController
{
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public String showUsers(Model model)
	{
		model.addAttribute("title", "Users");

		return "showUsers";
	}

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public String showUsers(@Valid @ModelAttribute User user, Model model)
	{
		model.addAttribute("title", "Users");

		return "showUser";
	}
}
