package com.shareki.model.hybernate.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the cityneighbour database table.
 * 
 */
@Entity
public class Cityneighbour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	private String villagename;

	//bi-directional many-to-one association to City
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="nearestcity")
	private City city;

	//bi-directional many-to-one association to Sharekinew
	@JsonIgnore
	@OneToMany(mappedBy="cityneighbour")
	private List<Sharekinews> sharekinews=new ArrayList<Sharekinews>();

	public Cityneighbour() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getVillagename() {
		return this.villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Sharekinews> getSharekinews() {
		return this.sharekinews;
	}

	public void setSharekinews(List<Sharekinews> sharekinews) {
		this.sharekinews = sharekinews;
	}

	public Sharekinews addSharekinew(Sharekinews sharekinew) {
		getSharekinews().add(sharekinew);
		sharekinew.setCityneighbour(this);

		return sharekinew;
	}

	public Sharekinews removeSharekinew(Sharekinews sharekinew) {
		getSharekinews().remove(sharekinew);
		sharekinew.setCityneighbour(null);

		return sharekinew;
	}

}