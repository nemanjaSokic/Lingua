package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@OneToOne
	@JoinTable(name="tbl_nalogNastavnik", joinColumns = @JoinColumn(name= "id_nastavnika"), inverseJoinColumns=@JoinColumn(name="korisnicko_ime"))
	protected Korisnik korisnik;
	
	public Nastavnik(){}
	
	public Nastavnik(String ime, String prezime) {
		super(ime,prezime);
		this.ime = ime;
		this.prezime = prezime;
	}

	public Nastavnik(String ime, String prezime, Jezik predaje, Korisnik k) {
		super(ime, prezime);
		this.predaje = predaje;
		this.korisnik = k;
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

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	@Override
	public String ispisiImePretime() {
		return "Profesor " + getIme() + " " + getPrezime();
	}
	
	
}
