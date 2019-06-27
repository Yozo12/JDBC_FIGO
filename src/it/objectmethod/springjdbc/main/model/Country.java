package it.objectmethod.springjdbc.main.model;


	public class Country {
		String codNation, nameNation, nameContinent;
		int population;

		public int getPopulation() {
			return population;
		}

		public void setPopulation(int population) {
			this.population = population;
		}

		public String getCodNation() {
			return codNation;
		}

		public void setCodNation(String codNation) {
			this.codNation = codNation;
		}

		public String getNameNation() {
			return nameNation;
		}

		public void setNameNation(String nameNation) {
			this.nameNation = nameNation;
		}

		public String getNameContinent() {
			return nameContinent;
		}

		public void setNameContinent(String nameContinent) {
			this.nameContinent = nameContinent;
		}
	}


