package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;




@Entity
@Table(name="tblOcene")
@JsonSerialize
public class Ocena {

	@Id
	@GeneratedValue
	@Column(name="idOcene")
	protected Long idOcene;
	@Column(name="vrednost")
	protected Integer vrednost;
	@OneToOne
	protected Test test;
	@ManyToOne(fetch=FetchType.EAGER)
	//@JsonBackReference
	protected Ucenik ucenik;
	@Column(name="komnetar")
	protected String komentar;
	
	public Ocena(Integer vrednost, Test test,Ucenik ucenik, String komentar) {
		super();
		this.vrednost = vrednost;
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

	public Integer getVrednost() {
		return vrednost;
	}

	public void setVrednost(Integer vrednost) {
		this.vrednost = vrednost;
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
