package xyz.morlotti.escalade.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import xyz.morlotti.escalade.models.beans.User;

@SessionAttributes(value = "currentUser", types = {User.class})
public abstract class AbstractController
{
	@ModelAttribute("currentUser")
	public User currentUser()
	{
		User currentUser = new User();

		currentUser.initGuest();

		return currentUser;
	}
}
