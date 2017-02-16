package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author nemanja
 *
 */
@Entity
@Table(name="tblNastavnici")
public class Nastavnik extends Osoba {
	
	@Id
	@GeneratedValue
	@Column(name="id_nastavnika")
	protected int id;
	@OneToOne
	protected Jezik predaje;
	
	public Nastavnik(){}
	
	public Nastavnik(String ime, String prezime, int jmbg) {
		super(ime,prezime,jmbg);
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}

	public Nastavnik(String ime, String prezime, int jmbg, Jezik predaje) {
		super(ime, prezime, jmbg);
		this.predaje = predaje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jezik getPredaje() {
		return predaje;
	}

	public void setPredaje(Jezik predaje) {
		this.predaje = predaje;
	}

	@Override
	public String ispisiImePretime() {
		return "Profesor " + getIme() + " " + getPrezime();
	}
	
	
}
