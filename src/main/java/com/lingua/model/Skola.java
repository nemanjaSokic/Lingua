package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblSkola")
public class Skola {
	@Column
	protected String naziv;
	@Column
	protected String adresa;
	@Column
	protected String email;
	@Column
	protected String internet;
	@Column
	protected String brRacuna;
	@Column
	protected int telefon;
	@Id
	@Column
	protected int pib;
	@Column
	protected int maticniBroj;
	
	public Skola(String naziv, String adresa, String email, String internet, String brRacuna, int telefon, int pib,
			int maticniBroj) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email;
		this.internet = internet;
		this.brRacuna = brRacuna;
		this.telefon = telefon;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
	}
	@Override
	public String toString() {
		return "\nSkola " + naziv + "\nadresa: " + adresa + "\nbroj telefona: " + telefon + "\nWEB: " + internet + "\n";
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
	}
	public String getBrRacuna() {
		return brRacuna;
	}
	public void setBrRacuna(String brRacuna) {
		this.brRacuna = brRacuna;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	public int getPib() {
		return pib;
	}
	public void setPib(int pib) {
		this.pib = pib;
	}
	public int getMaticniBroj() {
		return maticniBroj;
	}
	public void setMaticniBroj(int maticniBroj) {
		this.maticniBroj = maticniBroj;
	}
	
	
}
