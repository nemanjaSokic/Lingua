package com.lingua.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;




@Entity
@Table(name="tblTestovi")
@JsonSerialize
public class Test {

	@Id
	@GeneratedValue
	@Column(name="testId")
	protected Long testId;
	@Column(name="naslov")
	protected String naslov;
	@Column(name="link")
	protected String link;
	@ManyToOne(fetch=FetchType.EAGER)
	//@JsonBackReference
	protected Kurs kurs;
	@Column(name="date")
	protected Date datum;
	
	public Test(String naslov, String link, Kurs kurs, Date datum) {
		super();
		this.naslov = naslov;
		this.link = link;
		this.kurs = kurs;
		this.datum = datum;
	}
	
	public Test() {
		super();
		long time = System.currentTimeMillis();
		this.datum = new Date(time);
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
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

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
		if(kurs != null && !kurs.getTestovi().contains(this)){
			kurs.getTestovi().add(this);
		}
	}
	
	
}
