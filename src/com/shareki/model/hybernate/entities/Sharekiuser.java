package com.shareki.model.hybernate.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the sharekiuser database table.
 * 
 */
@Entity
public class Sharekiuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String email;

	private String firstname;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	private String lastname;

	private String passwd;

	private String phone;

	private String userid;

	//bi-directional many-to-one association to Sharekicomment
	@JsonIgnore
	@OneToMany(mappedBy="sharekiuser")
	private List<Sharekicomment> sharekicomments=new ArrayList<Sharekicomment>();

	//bi-directional many-to-one association to Sharekinew
	@JsonIgnore
	@OneToMany(mappedBy="sharekiuser")
	private List<Sharekinews> sharekinews=new ArrayList<Sharekinews>();

	//bi-directional many-to-one association to Country
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="citizenship")
	private Country country;

	public Sharekiuser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<Sharekicomment> getSharekicomments() {
		return this.sharekicomments;
	}

	public void setSharekicomments(List<Sharekicomment> sharekicomments) {
		this.sharekicomments = sharekicomments;
	}

	public Sharekicomment addSharekicomment(Sharekicomment sharekicomment) {
		getSharekicomments().add(sharekicomment);
		sharekicomment.setSharekiuser(this);

		return sharekicomment;
	}

	public Sharekicomment removeSharekicomment(Sharekicomment sharekicomment) {
		getSharekicomments().remove(sharekicomment);
		sharekicomment.setSharekiuser(null);

		return sharekicomment;
	}

	public List<Sharekinews> getSharekinews() {
		return this.sharekinews;
	}

	public void setSharekinews(List<Sharekinews> sharekinews) {
		this.sharekinews = sharekinews;
	}

	public Sharekinews addSharekinew(Sharekinews sharekinew) {
		getSharekinews().add(sharekinew);
		sharekinew.setSharekiuser(this);

		return sharekinew;
	}

	public Sharekinews removeSharekinew(Sharekinews sharekinew) {
		getSharekinews().remove(sharekinew);
		sharekinew.setSharekiuser(null);

		return sharekinew;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}