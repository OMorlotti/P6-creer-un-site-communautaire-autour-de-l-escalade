package xyz.morlotti.escalade.controllers;

import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.UserDAO;
import xyz.morlotti.escalade.models.BeanException;

@Controller
public class UserController
{
	@Autowired
	private UserDAO m_userDAO;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public String showUsers(Model model) throws Exception
	{
		model.addAttribute("title", "Utilisateurs");

		model.addAttribute("users", m_userDAO.list());

		return "showUsers";
	}

	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable(value = "id") final int id, Model model)
	{
		model.addAttribute("title", "Utilisateur");

		model.addAttribute("user", m_userDAO.get(id));

		return "showUpdateUser";
	}

	// @Valid @ModelAttribute User user

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public String addUser(
		@RequestParam("firstname") String firstname,
		@RequestParam("lastname") String lastname,
		@RequestParam("login") String login,
		@RequestParam("password") String password,
		@RequestParam("sex") String sex,
		@RequestParam("birthdate") String birthdate,
		@RequestParam("phone") String phone,
		@RequestParam("email") String email,
		@RequestParam("role") String role,
		Model model) throws BeanException
	{
		User user = new User();

		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setLogin(login);
		user.setPassword(password);
		user.setSex(User.Sex.parseSex(sex));
		user.setBirthdate(birthdate);
		user.setPhone(phone);
		user.setEmail(email);
		user.setRole(User.Role.parseRole(role));

		m_userDAO.add(user);

		model.addAttribute("title", "Utilisateur ajouté");

		model.addAttribute("login", login);

		return "addUser";
	}

	@RequestMapping(path = "/user/update/{id}", method = RequestMethod.POST)
	public String updateUser(
		@PathVariable(value = "id") final int id,
		@RequestParam("firstname") String firstname,
		@RequestParam("lastname") String lastname,
		@RequestParam("login") String login,
		@RequestParam("password") String password,
		@RequestParam("sex") String sex,
		@RequestParam("birthdate") String birthdate,
		@RequestParam("phone") String phone,
		@RequestParam("email") String email,
		@RequestParam("role") String role, Model model) throws BeanException
	{
		User user = m_userDAO.get(id);

		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setLogin(login);
		user.setPassword(password);
		user.setSex(User.Sex.parseSex(sex));
		user.setBirthdate(birthdate);
		user.setPhone(phone);
		user.setEmail(email);
		user.setRole(User.Role.parseRole(role));

		m_userDAO.update(user);

		model.addAttribute("title", "Utilisateur modifié");

		model.addAttribute("message", "Utilisateur modifié avec succès !");

		model.addAttribute("message_type", "success");

		model.addAttribute("user", user);

		return "showUpdateUser";
	}

	@RequestMapping(path = "/user/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable(value = "id") final int id, Model model)
	{
		m_userDAO.delete(id);

		model.addAttribute("title", "Utilisateur supprimé");

		model.addAttribute("id", id);

		return "deleteUser";
	}
}
