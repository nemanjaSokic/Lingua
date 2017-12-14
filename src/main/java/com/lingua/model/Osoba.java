package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Osoba{
	@Column
	protected String ime;
	@Column
	protected String prezime;
	
	
	
	public Osoba() {
		super();
	}


	public Osoba(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public abstract String ispisiImePretime();
}
