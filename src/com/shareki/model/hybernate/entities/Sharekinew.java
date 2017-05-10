package com.shareki.model.hybernate.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sharekinews database table.
 * 
 */
@Entity
@Table(name="sharekinews")
public class Sharekinew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private byte ehelp;

	@Lob
	private byte[] image;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	private String news;

	private String newsid;

	private String title;

	private java.math.BigInteger user;

	private int village;

	public Sharekinew() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getEhelp() {
		return this.ehelp;
	}

	public void setEhelp(byte ehelp) {
		this.ehelp = ehelp;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getNews() {
		return this.news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getNewsid() {
		return this.newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.math.BigInteger getUser() {
		return this.user;
	}

	public void setUser(java.math.BigInteger user) {
		this.user = user;
	}

	public int getVillage() {
		return this.village;
	}

	public void setVillage(int village) {
		this.village = village;
	}

}