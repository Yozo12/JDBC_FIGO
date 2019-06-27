package it.objectmethod.springjdbc.main.dao;

import java.util.List;

import it.objectmethod.springjdbc.main.model.City;

public interface ICityDao {
	public List<City> getNameCitybyNation(String parNation);
	public void deleteCity (int id) ;
	public City cityById(int id) ;
	public void ModCity(String newName, String newPopulation, String newCodNation, String idCity);
	public void AddCity(String newName, String newPopulation, String newCodNation);
	public List<City> getNameCitybyNationOrd(String codNazione, String ord);
}
