package com.shareki.model.hybernate.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the sharekicomment database table.
 * 
 */
@Entity
public class Sharekicomment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String comment;

	private String commentid;

	private Byte dirtyflag;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	//bi-directional many-to-one association to Sharekinew
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="newsid")
	private Sharekinews sharekinew;

	//bi-directional many-to-one association to Sharekiuser
	@ManyToOne
	@JoinColumn(name="userid")
	private Sharekiuser sharekiuser;

	public Sharekicomment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentid() {
		return this.commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public byte getDirtyflag() {
		return this.dirtyflag;
	}

	public void setDirtyflag(byte dirtyflag) {
		this.dirtyflag = dirtyflag;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Sharekinews getSharekinew() {
		return this.sharekinew;
	}

	public void setSharekinew(Sharekinews sharekinew) {
		this.sharekinew = sharekinew;
	}

	public Sharekiuser getSharekiuser() {
		return this.sharekiuser;
	}

	public void setSharekiuser(Sharekiuser sharekiuser) {
		this.sharekiuser = sharekiuser;
	}

}