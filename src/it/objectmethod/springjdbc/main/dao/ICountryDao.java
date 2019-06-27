package it.objectmethod.springjdbc.main.dao;

import java.util.List;

import it.objectmethod.springjdbc.main.model.Country;

public interface ICountryDao {
	public List<String> getNameContinent();

	public List<Country> getNazioniByContinent(String ParContinent);

	public List<Country> getAllNazioni();
}
