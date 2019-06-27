package it.objectmethod.springjdbc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.springjdbc.main.dao.ICountryDao;
import it.objectmethod.springjdbc.main.model.Country;

@Controller
public class CountryController {
	@Autowired
	private ICountryDao countryDaoImp;

	@RequestMapping("/continent")
	public String differentContinent(ModelMap model) {
		List<String> ContinentList = countryDaoImp.getNameContinent();
		model.addAttribute("continent", ContinentList);
		return "continentList";
	}

	@RequestMapping("/{continent}/nazioni")
	public String NazioniByContinent(@PathVariable("continent") String continent, ModelMap model) {
		List<Country> nationList = countryDaoImp.getNazioniByContinent(continent);
		model.addAttribute("nazioni", nationList);
		return "nationList";
	}

	@RequestMapping("/allnazioni")
	public String AllNation(ModelMap model) {
		List<Country> ListNazioni = countryDaoImp.getAllNazioni();
		model.addAttribute("nazioni", ListNazioni);
		return "menuAddCity";
	}
}
