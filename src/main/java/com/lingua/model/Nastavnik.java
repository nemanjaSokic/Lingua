package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author nemanja
 *
 */
@Entity
@Table(name="tblNastavnici")
public class Nastavnik extends Korisnik {
	
	//@Id
	//@GeneratedValue
	@Column(name="id_nastavnika")
	protected int id;
	@OneToOne
	protected Jezik predaje;
	protected static int count = 0;
	
	public Nastavnik(){}
	


	public Nastavnik(String ime, String prezime, TipKorisnika tipKorisnika, String korisnickoIme, String sifraKorisnika,
		Long telefonKorisnika, String email, Boolean registrovan, String napomena, Jezik predaje) {
	super(ime, prezime, tipKorisnika, korisnickoIme, sifraKorisnika, telefonKorisnika, email, registrovan, napomena);
	this.id = count++;
	this.predaje = predaje;
}



	public Nastavnik(String ime, String prezime, Jezik jezik, String korisnickoIme) {
		super(korisnickoIme);
		this.ime = ime;
		this.prezime = prezime;
		this.predaje = jezik;
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
