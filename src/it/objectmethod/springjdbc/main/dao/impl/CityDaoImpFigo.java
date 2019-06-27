package it.objectmethod.springjdbc.main.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.springjdbc.main.dao.ICityDao;
import it.objectmethod.springjdbc.main.model.City;
import it.objectmethod.springjdbc.main.model.Country;

public class CityDaoImpFigo extends NamedParameterJdbcDaoSupport implements ICityDao {
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
	public List<City> getNameCitybyNation(String parNation) {
		List<City> CityDao = null;
		String sql = "select t1.ID id, t1.Name cityName, t1.CountryCode codNation, t1.Population population from city t1 JOIN country t2 ON t1.countrycode=t2.Code  where t1.CountryCode=:Codiceparam ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Codiceparam", parNation);
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);

		CityDao = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return CityDao;
	}

	@Override
	public void deleteCity(int id) {
		String sql = "delete from city where id=:id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		getNamedParameterJdbcTemplate().update(sql, params);
	}

	@Override
	public City cityById(int id) {
		City CityDao = null;
		String sql = "select Name cityName,CountryCode codNation,population population,ID id from city where id=:id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
		CityDao = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return CityDao;
	}

	@Override
	public void modCity(String newName, String newPopulation, String newCodNation, String idCity) {
		String sql = "UPDATE city SET city.Name =:parName, city.population=:parPop, city.countryCode =:parCode where city.ID= :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", idCity);
		params.addValue("parName", newName);
		params.addValue("parPop", newPopulation);
		params.addValue("parCode", newCodNation);
		getNamedParameterJdbcTemplate().update(sql, params);
	}

	@Override
	public void addCity(String newName, String newPopulation, String newCodNation) {
		String sql = "INSERT INTO city(Name, population, CountryCode) VALUES ( :parName , :parPop , :parCode)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parName", newName);
		params.addValue("parPop", newPopulation);
		params.addValue("parCode", newCodNation);
		getNamedParameterJdbcTemplate().update(sql, params);
	}

	@Override
	public List<City> getNameCitybyNationOrd(String codNazione, String ord) {
		List<City> CityDao = null;
		String parametro = null;
		String qry = "select t1.ID id, t1.Name cityName, t1.CountryCode  codNation, t1.Population population from city t1 JOIN country t2 ON t1.countrycode=t2.Code  where t1.CountryCode=:parCode ";
		if (ord.equals("Alfabetico")) {
			parametro = "order by cityName ASC";
			qry = qry + parametro;
		} else if (ord.equals("Alfabetico Decrescente")) {
			parametro = "order by cityName DESC";
			qry = qry + parametro;
		} else if (ord.equals("Popolazione Crescente")) {
			parametro = " order by population ASC";
			qry = qry + parametro;
		} else if (ord.equals("Popolazione Decrescente")) {
			parametro = " order by population DESC";
			qry = qry + parametro;
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parCode", codNazione);
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
		CityDao = getNamedParameterJdbcTemplate().query(qry, params, rm);
		return CityDao;
	}

	@Override
	public List<Country> getAllNazioni() {

		String sql = "select Code codNation,Name nameNation, Population population,Continent nameContinent from country";
		List<Country> country = null;
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().query(sql, rm);
		return country;
	}
}
