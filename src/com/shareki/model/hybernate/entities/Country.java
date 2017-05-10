package com.shareki.model.hybernate.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String code;

	@JsonIgnore
	private Integer capital;

	private String code2;

	@JsonIgnore
	private String continent;
	
	@JsonIgnore
	private Float gnp;

	@JsonIgnore
	private Float GNPOld;

	@JsonIgnore
	private String governmentForm;

	@JsonIgnore
	private String headOfState;

	@JsonIgnore
	private Short indepYear;

	@JsonIgnore
	private Float lifeExpectancy;

	private String localName;

	private String name;

	@JsonIgnore
	private Integer population;

	@JsonIgnore
	private String region;

	@JsonIgnore
	private Float surfaceArea;

	//bi-directional many-to-one association to City
	@JsonIgnore
	@OneToMany(mappedBy="country")
	private List<City> cities;

	//bi-directional many-to-one association to Sharekiuser
	@JsonIgnore
	@OneToMany(mappedBy="country")
	private List<Sharekiuser> sharekiusers=new ArrayList<Sharekiuser>();

	//bi-directional many-to-one association to State
	@JsonIgnore
	@OneToMany(mappedBy="country")
	private List<State> states;

	public Country() {
		
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapital() {
		return this.capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return this.code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getContinent() {
		return this.continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public float getGnp() {
		return this.gnp;
	}

	public void setGnp(float gnp) {
		this.gnp = gnp;
	}

	public Float getGNPOld() {
		return this.GNPOld;
	}

	public void setGNPOld(float GNPOld) {
		this.GNPOld = GNPOld;
	}

	public String getGovernmentForm() {
		return this.governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return this.headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public short getIndepYear() {
		return this.indepYear;
	}

	public void setIndepYear(short indepYear) {
		this.indepYear = indepYear;
	}

	public float getLifeExpectancy() {
		return this.lifeExpectancy;
	}

	public void setLifeExpectancy(float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getLocalName() {
		return this.localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return this.population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getSurfaceArea() {
		return this.surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setCountry(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setCountry(null);

		return city;
	}

	public List<Sharekiuser> getSharekiusers() {
		return this.sharekiusers;
	}

	public void setSharekiusers(List<Sharekiuser> sharekiusers) {
		this.sharekiusers = sharekiusers;
	}

	public Sharekiuser addSharekiuser(Sharekiuser sharekiuser) {
		getSharekiusers().add(sharekiuser);
		sharekiuser.setCountry(this);

		return sharekiuser;
	}

	public Sharekiuser removeSharekiuser(Sharekiuser sharekiuser) {
		getSharekiusers().remove(sharekiuser);
		sharekiuser.setCountry(null);

		return sharekiuser;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setCountry(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setCountry(null);

		return state;
	}

}