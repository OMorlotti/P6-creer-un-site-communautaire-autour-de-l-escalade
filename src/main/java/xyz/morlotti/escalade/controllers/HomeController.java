package xyz.morlotti.escalade.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends AbstractController
{
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showIndex(Model model)
	{
		model.addAttribute("title", "Home");

		return "index";
	}
}
