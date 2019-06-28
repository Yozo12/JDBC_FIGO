package it.objectmethod.springjdbc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.springjdbc.main.dao.ICityDao;
import it.objectmethod.springjdbc.main.model.City;
import it.objectmethod.springjdbc.main.model.Country;
import it.objectmethod.springjdbc.main.utils.Constants;

@Controller
public class CityController {

	@Autowired
	private ICityDao CityDaoImp;

	@RequestMapping("/{nazione}/citta")
	public String NazioniByContinent(@PathVariable("nazione") String nazione, ModelMap model) {

		
		
		List<City> cityList = CityDaoImp.getCitiesNamebyCountry(nazione);
		model.addAttribute("citta", cityList);
		model.addAttribute("AZ", Constants.AZ);
		model.addAttribute("POPA", Constants.POPA);

		return "cityList";
	}

	@RequestMapping("/delete")
	public String Delete(@RequestParam("cityid") int cityid, @RequestParam("codNazione") String codNazione) {
		CityDaoImp.deleteCity(cityid);
		return "forward:" + codNazione + "/citta";
	}

	@RequestMapping("/citta-load-edit")
	public String cittaLoad(@RequestParam("id") int id, ModelMap model) {
		List<Country> listNazioni = null;
		City cittabyid = null;
		listNazioni = CityDaoImp.getAllCountries();
		if (id > 0) {

			cittabyid = CityDaoImp.getCityById(id);

		}
		model.addAttribute("nazioni", listNazioni);
		model.addAttribute("citta", cittabyid);

		return "menuAddCity";

	}

	@RequestMapping("/modifica-aggiungi")
	public String modifica(@RequestParam("id") String id, @RequestParam("newPopulation") String newPopulation,
			@RequestParam("newCodNation") String newCodNation, @RequestParam("newCity") String newCity) {

		if (id != "") {
			CityDaoImp.modCity(newCity, newPopulation, newCodNation, id);
		} else if (id == "") {
			CityDaoImp.addCity(newCity, newPopulation, newCodNation);
		}
		return "forward:" + newCodNation + "/citta";
	}

	@RequestMapping("/citta/ordina")
	public String ordina(@RequestParam("codNazione") String codNazione, @RequestParam("ord") String ord,
			ModelMap model) {

		String AZ = null;
		String POPA = null;
		if (ord.equals(Constants.AZ)) {
			AZ = Constants.ZA;
		} else {
			AZ = Constants.AZ;
		}
		if (ord.equals(Constants.POPA)) {
			POPA = Constants.POPD;
		} else {
			POPA = Constants.POPA;
		}
		List<City> cityList = CityDaoImp.getCitiesNamebyCountryOrderBy(codNazione, ord);
		model.addAttribute("citta", cityList);
		model.addAttribute("AZ", AZ);
		model.addAttribute("POPA", POPA);
		return "cityList";
	}
}
