package com.shareki.model.hybernate.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.sun.istack.internal.Nullable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the sharekinews database table.
 * 
 */
@Entity
@Table(name="sharekinews")
public class Sharekinews implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private Byte ehelp;

	@Lob
	@Column(nullable=true,length = 5971520)
	private byte[] image;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	private String news;

	private String newsid;

	private String title;

	//bi-directional many-to-one association to Sharekicomment
	@JsonIgnore
	@OneToMany(mappedBy="sharekinew")
	private List<Sharekicomment> sharekicomments=new ArrayList<Sharekicomment>();

	//bi-directional many-to-one association to Cityneighbour
	@ManyToOne
	@JoinColumn(name="village")
	private Cityneighbour cityneighbour;

	//bi-directional many-to-one association to Sharekiuser
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user")
	private Sharekiuser sharekiuser;

	public Sharekinews() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Sharekicomment> getSharekicomments() {
		return this.sharekicomments;
	}

	public void setSharekicomments(List<Sharekicomment> sharekicomments) {
		this.sharekicomments = sharekicomments;
	}

	public Sharekicomment addSharekicomment(Sharekicomment sharekicomment) {
		getSharekicomments().add(sharekicomment);
		sharekicomment.setSharekinew(this);

		return sharekicomment;
	}

	public Sharekicomment removeSharekicomment(Sharekicomment sharekicomment) {
		getSharekicomments().remove(sharekicomment);
		sharekicomment.setSharekinew(null);

		return sharekicomment;
	}

	public Cityneighbour getCityneighbour() {
		return this.cityneighbour;
	}

	public void setCityneighbour(Cityneighbour cityneighbour) {
		this.cityneighbour = cityneighbour;
	}

	public Sharekiuser getSharekiuser() {
		return this.sharekiuser;
	}

	public void setSharekiuser(Sharekiuser sharekiuser) {
		this.sharekiuser = sharekiuser;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte getEhelp() {
		return this.ehelp;
	}

	public void setEhelp(byte ehelp) {
		this.ehelp = ehelp;
	}

}