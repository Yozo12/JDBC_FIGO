package it.objectmethod.springjdbc.main.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.springjdbc.main.dao.ICountryDao;
import it.objectmethod.springjdbc.main.model.Country;

public class CountryDaoImpFigo extends NamedParameterJdbcDaoSupport implements ICountryDao {
//	@Override
//	public Country getCountryByCode(String code) {
//		Country country = null;
//		String sql = "SELECT code codice, name nome FROM country WHERE code = :codiceInserito";
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("codiceInserito", code);
//		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
//		country = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
//		return country;
//	}
	@Override
	public List<String> getNameContinent() {
		List<String> country = null;
		String sql = "select distinct continent nameContinent from country";
		country = getJdbcTemplate().queryForList(sql, String.class);
		return country;
	}

	@Override
	public List<Country> getNazioniByContinent(String ParContinent) {
		List<Country> country = null;
		String sql = "select name nameNation, Code codNation, Continent nameContinent, population from country where continent=:continentparam";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("continentparam", ParContinent);
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return country;
	}

	
}
