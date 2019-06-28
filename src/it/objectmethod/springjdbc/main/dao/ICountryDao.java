package it.objectmethod.springjdbc.main.dao;

import java.util.List;

import it.objectmethod.springjdbc.main.model.Country;

public interface ICountryDao {
	public List<String> getContinentsName();

	public List<Country> getCountriesByContinent(String ParContinent);

}
