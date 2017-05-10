package com.shareki.model.hybernate.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String district;

	private String name;

	private Integer population;

	//bi-directional many-to-one association to Country
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CountryCode")
	private Country country;

	//bi-directional many-to-one association to State
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="StateID")
	private State state;

	//bi-directional many-to-one association to Cityneighbour
	@JsonIgnore
	@OneToMany(mappedBy="city")
	private List<Cityneighbour> cityneighbours=new ArrayList<Cityneighbour>();

	public City() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Cityneighbour> getCityneighbours() {
		return this.cityneighbours;
	}

	public void setCityneighbours(List<Cityneighbour> cityneighbours) {
		this.cityneighbours = cityneighbours;
	}

	public Cityneighbour addCityneighbour(Cityneighbour cityneighbour) {
		getCityneighbours().add(cityneighbour);
		cityneighbour.setCity(this);

		return cityneighbour;
	}

	public Cityneighbour removeCityneighbour(Cityneighbour cityneighbour) {
		getCityneighbours().remove(cityneighbour);
		cityneighbour.setCity(null);

		return cityneighbour;
	}

}