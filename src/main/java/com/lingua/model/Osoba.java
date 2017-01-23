package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass 
public abstract class Osoba {
	@Column
	protected String ime;
	@Column
	protected String prezime;
	@Column
	protected int jmbg;
	
	
	
	public Osoba(String ime, String prezime, int jmbg) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	
	
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public int getJmbg() {
		return jmbg;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}
	
	public abstract String ispisiImePretime();
}
