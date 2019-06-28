package it.objectmethod.springjdbc.main.dao;

import java.util.List;

import it.objectmethod.springjdbc.main.model.City;
import it.objectmethod.springjdbc.main.model.Country;

public interface ICityDao {
	public List<City> getNameCitybyNation(String parNation);

	public void deleteCity(int id);

	public City cityById(int id);

	public void modCity(String newName, String newPopulation, String newCodNation, String idCity);

	public void addCity(String newName, String newPopulation, String newCodNation);

	public List<City> getNameCitybyNationOrd(String codNazione, String ord);

	public List<Country> getAllNazioni();
}
