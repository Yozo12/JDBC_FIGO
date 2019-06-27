package it.objectmethod.springjdbc.main.model;

public class City {
	
	int population;
	String cityName, codNation, id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCodNation() {
		return codNation;
	}
	
	public void setCodNation(String codNation) {
		this.codNation = codNation;
	}

}
