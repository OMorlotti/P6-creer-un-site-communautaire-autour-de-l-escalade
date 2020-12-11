package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.BeanException;
import xyz.morlotti.escalade.models.beans.Secteur;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.SecteurDAO;
import xyz.morlotti.escalade.models.daos.SpotDAO;

@Controller
public class SecteurController
{
	@Autowired
	private SecteurDAO secteurDAO;

	@Autowired
	private SpotDAO spotDAO;

	@RequestMapping(path = "/secteurs", method = RequestMethod.GET)
	public String showSecteurs(Model model) throws Exception
	{
		model.addAttribute("title", "Secteurs");

		model.addAttribute("secteurs", secteurDAO.list());

		model.addAttribute("spots", spotDAO.list());

		return "showSecteurs";
	}

	@RequestMapping(path = "/secteur/{id}", method = RequestMethod.GET)
	public String showSecteur(@PathVariable(value = "id") final int id, Model model) throws Exception
	{
		model.addAttribute("title", "Secteur");

		model.addAttribute("secteur", secteurDAO.get(id));

		model.addAttribute("spots", spotDAO.list());

		return "showSecteur";
	}

	// @Valid @ModelAttribute Secteur secteur

	@RequestMapping(path = "/secteur", method = RequestMethod.POST)
	public String addSecteur(
		@RequestParam("name") String name,
		@RequestParam("spotfk") int spotFK,
		Model model) throws BeanException
	{
		Spot spot = spotDAO.get(spotFK);

		Secteur secteur = new Secteur();

		secteur.setName(name);
		secteur.setSpotFK(spot);

		secteurDAO.add(secteur);

		model.addAttribute("title", "Secteur ajouté");

		model.addAttribute("name", name);

		return "addSecteur";
	}

	@RequestMapping(path = "/secteur/update/{id}", method = RequestMethod.POST)
	public String updateSecteur(
		@PathVariable(value = "id") final int id,
		@RequestParam("name") String name,
		@RequestParam("spotfk") int spotFK,
		Model model) throws Exception
	{
		Spot spot = spotDAO.get(spotFK);

		Secteur secteur = secteurDAO.get(id);

		secteur.setName(name);
		secteur.setSpotFK(spot);

		secteurDAO.update(secteur);

		model.addAttribute("title", "Secteur modifié");

		model.addAttribute("message", "Secteur modifié avec succès !");

		model.addAttribute("message_type", "success");

		model.addAttribute("secteur", secteur);

		model.addAttribute("spots", spotDAO.list());

		return "showSecteur";
	}

	@RequestMapping(path = "/secteur/delete/{id}", method = RequestMethod.GET)
	public String deleteSecteur(@PathVariable(value = "id") final int id, Model model)
	{
		secteurDAO.delete(id);

		model.addAttribute("title", "Secteur supprimé");

		model.addAttribute("id", id);

		return "deleteSecteur";
	}
}
