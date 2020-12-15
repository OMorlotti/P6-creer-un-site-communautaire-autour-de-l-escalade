package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.BeanException;
import xyz.morlotti.escalade.models.beans.Sector;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.daos.SectorDAO;
import xyz.morlotti.escalade.models.daos.SpotDAO;

@Controller
public class SectorController
{
	@Autowired
	private SectorDAO sectorDAO;

	@Autowired
	private SpotDAO spotDAO;

	@RequestMapping(path = "/secteurs", method = RequestMethod.GET)
	public String showSectors(Model model) throws Exception
	{
		model.addAttribute("title", "Secteurs");

		model.addAttribute("secteurs", sectorDAO.list());

		model.addAttribute("spots", spotDAO.list());

		return "showSectors";
	}

	@RequestMapping(path = "/secteur/{id}", method = RequestMethod.GET)
	public String showSector(@PathVariable(value = "id") final int id, Model model) throws Exception
	{
		model.addAttribute("title", "Secteur");

		model.addAttribute("secteur", sectorDAO.get(id));

		model.addAttribute("spots", spotDAO.list());

		return "showUpdateSector";
	}

	// @Valid @ModelAttribute Secteur secteur

	@RequestMapping(path = "/secteur", method = RequestMethod.POST)
	public String addSector(
		@RequestParam("name") String name,
		@RequestParam("spotfk") int spotFK,
		Model model) throws BeanException
	{
		Spot spot = spotDAO.get(spotFK);

		Sector secteur = new Sector();

		secteur.setName(name);
		secteur.setSpotFK(spot);

		sectorDAO.add(secteur);

		model.addAttribute("title", "Secteur ajouté");

		model.addAttribute("name", name);

		return "addSector";
	}

	@RequestMapping(path = "/secteur/update/{id}", method = RequestMethod.POST)
	public String updateSector(
		@PathVariable(value = "id") final int id,
		@RequestParam("name") String name,
		@RequestParam("spotfk") int spotFK,
		Model model) throws Exception
	{
		Spot spot = spotDAO.get(spotFK);

		Sector sector = sectorDAO.get(id);

		sector.setName(name);
		sector.setSpotFK(spot);

		sectorDAO.update(sector);

		model.addAttribute("title", "Secteur modifié");

		model.addAttribute("message", "Secteur modifié avec succès !");

		model.addAttribute("message_type", "success");

		model.addAttribute("secteur", sector);

		model.addAttribute("spots", spotDAO.list());

		return "showUpdateSector";
	}

	@RequestMapping(path = "/secteur/delete/{id}", method = RequestMethod.GET)
	public String deleteSector(@PathVariable(value = "id") final int id, Model model)
	{
		sectorDAO.delete(id);

		model.addAttribute("title", "Secteur supprimé");

		model.addAttribute("id", id);

		return "deleteSector";
	}
}
