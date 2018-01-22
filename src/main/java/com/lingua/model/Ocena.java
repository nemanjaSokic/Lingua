package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;




@Entity
@Table(name="tblOcene")
@JsonSerialize
public class Ocena {

	@Id
	@GeneratedValue
	@Column(name="idOcene")
	protected Long idOcene;
	@Column
	protected Double gramatika;
	@Column
	protected Double vokabular;
	@Column
	protected Double govor;
	@Column(name="ukupnaVrednost")
	protected Double ukupnaVrednost;
	@OneToOne
	protected Test test;
	@ManyToOne(fetch=FetchType.EAGER)
	//@JsonBackReference
	protected Ucenik ucenik;
	@Column(name="komnetar")
	protected String komentar;
	
	public Ocena(Double gramatika, Double vokabular, Double govor, Test test,
			Ucenik ucenik, String komentar) {
		super();
		this.gramatika = gramatika;
		this.vokabular = vokabular;
		this.govor = govor;
		this.ukupnaVrednost = gramatika+vokabular+govor;
		this.test = test;
		this.ucenik = ucenik;
		this.komentar = komentar;
	}

	public Ocena(Double ukupnaVrednost, Test test,Ucenik ucenik, String komentar) {
		this.ukupnaVrednost = ukupnaVrednost;
		this.test = test;
		this.ucenik = ucenik;
		this.komentar = komentar;
	}

	public Ocena() {
		super();
	}

	public Long getIdOcene() {
		return idOcene;
	}

	public void setIdOcene(Long idOcene) {
		this.idOcene = idOcene;
	}

	public Long getId() {
		return idOcene;
	}

	public void setId(Long id) {
		this.idOcene = id;
	}

	public Double getGramatika() {
		return gramatika;
	}

	public void setGramatika(Double gramatika) {
		this.gramatika = gramatika;
	}

	public Double getVokabular() {
		return vokabular;
	}

	public void setVokabular(Double vokabular) {
		this.vokabular = vokabular;
	}

	public Double getGovor() {
		return govor;
	}

	public void setGovor(Double govor) {
		this.govor = govor;
	}

	public Double getUkupnaVrednost() {
		return ukupnaVrednost;
	}

	public void setUkupnaVrednost(Double ukupnaVrednost) {
		this.ukupnaVrednost = ukupnaVrednost;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
		if(ucenik != null && !ucenik.getOcene().contains(this)){
			ucenik.getOcene().add(this);
		}
	}
	
	
}
