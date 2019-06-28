package it.objectmethod.springjdbc.main.dao;

import java.util.List;

import it.objectmethod.springjdbc.main.model.City;
import it.objectmethod.springjdbc.main.model.Country;

public interface ICityDao {
	public List<City> getCitiesNamebyCountry(String parNation);

	public void deleteCity(int id);

	public City  getCityById(int id);

	public void modCity(String newName, String newPopulation, String newCodNation, String idCity);

	public void addCity(String newName, String newPopulation, String newCodNation);

	public List<City> getCitiesNamebyCountryOrderBy(String codNazione, String ord);

	public List<Country> getAllCountries();
}
