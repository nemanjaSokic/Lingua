package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblTestovi")
public class Test {

	@Id
	@GeneratedValue
	@Column(name="testId")
	protected Long testId;
	@Column(name="naslov")
	protected String naslov;
	@Column(name="link")
	protected String link;
	
	public Test(String naslov, String link) {
		super();
		this.naslov = naslov;
		this.link = link;
	}
	
	public Test() {
		super();
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
