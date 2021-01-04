package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(path = "/sectors", method = RequestMethod.GET)
	public String showSectors(
		@RequestParam(name = "spot", required = false) Integer parentSpot, // Le parentSpot est passé dans l'url en ajoutan ?spot=<id>, il est facultatif et dans ce cas, on aura null dans parentSpot
		Model model) throws Exception
	{
		model.addAttribute("title", "Secteurs");

		if(parentSpot == null) {
			model.addAttribute("sectors", sectorDAO.list());
		}
		else {
			model.addAttribute("sectors", sectorDAO.list(parentSpot));
		}

		model.addAttribute("parentSpotId", parentSpot);
		model.addAttribute("spots", spotDAO.list());

		return "showSectors";
	}

	@RequestMapping(path = "/sector/{id}", method = RequestMethod.GET)
	public String showSector(@PathVariable(value = "id") final int id, Model model) throws Exception
	{
		model.addAttribute("title", "Secteur");

		model.addAttribute("sector", sectorDAO.get(id));

		model.addAttribute("spots", spotDAO.list());

		return "showUpdateSector";
	}

	@RequestMapping(path = "/sector", method = RequestMethod.POST)
	public String addSector(
		@RequestParam("name") String name,
		@RequestParam("spotfk") int spotFK,
		Model model) throws Exception
	{
		Spot spot = spotDAO.get(spotFK);

		Sector secteur = new Sector();

		secteur.setName(name);
		secteur.setSpotFK(spot);

		sectorDAO.add(secteur);

		/**/

		model.addAttribute("message", "Secteur ajouté avec succès !");

		model.addAttribute("message_type", "success");

		return showSectors(spotFK, model);
	}

	@RequestMapping(path = "/sector/update/{id}", method = RequestMethod.POST)
	public String updateSector(
		@PathVariable(value = "id") final int id,
		@RequestParam("name") String name,
		@RequestParam("spotfk") int spotFK,
		Model model) throws Exception
	{
		Spot spot = spotDAO.get(spotFK);

		int parentSpotId = spot.getId();

		Sector sector = sectorDAO.get(id);

		sector.setName(name);
		sector.setSpotFK(spot);

		sectorDAO.update(sector);

		/**/

		model.addAttribute("message", "Secteur ajouté avec succès !");

		model.addAttribute("message_type", "success");

		return showSectors(parentSpotId, model);
	}

	@RequestMapping(path = "/sector/delete/{id}", method = RequestMethod.GET)
	public String deleteSector(@PathVariable(value = "id") final int id, Model model) throws Exception
	{
		Sector sector = sectorDAO.get(id);

		int parentSpotId = sector.getSpotFK().getId();

		sectorDAO.delete(id);

		/**/

		model.addAttribute("message", "Secteur " + id + " supprimé avec succès !");

		model.addAttribute("message_type", "success");

		return showSectors(parentSpotId, model);
	}
}
