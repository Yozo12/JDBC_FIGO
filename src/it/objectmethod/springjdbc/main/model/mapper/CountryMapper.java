package it.objectmethod.springjdbc.main.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.springjdbc.main.model.Country;

public class CountryMapper implements org.springframework.jdbc.core.RowMapper<Country> {
	@Override 
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		country.setNameContinent(rs.getString("Continent"));
		country.setCodNation(rs.getString("Code"));
		country.setNameNation(rs.getString("Name"));
		country.setPopulation(rs.getInt("Population"));
		return country;

}
}
