package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="tblKorisnici")
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik extends Osoba{

	@Column(name="tip")
	protected TipKorisnika tipKorisnika;
	@Id
	@Column(name="korisnicko_ime")
	protected String korisnickoIme;
	@Column(name="sifra")
	protected String sifraKorisnika;
	@Column(name="telefon")
	protected Long telefonKorisnika;
	@Column(name="email")
	protected String email;
	@Column(name="reg")
	protected Boolean registrovan;
	@Column(name="napomena")
	protected String napomena;
	
	public Korisnik(String ime, String prezime, TipKorisnika tipKorisnika, String korisnickoIme, String sifraKorisnika,
			Long telefonKorisnika, String email, Boolean registrovan, String napomena) {
		super(ime, prezime);
		this.tipKorisnika = tipKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.sifraKorisnika = sifraKorisnika;
		this.telefonKorisnika = telefonKorisnika;
		this.email = email;
		this.registrovan = registrovan;
		this.napomena = napomena;
	}
	public Korisnik(TipKorisnika tipKorisnika, String korisnickoIme, String sifraKorisnika, Boolean registrovan, Long tel, String email) {
		super();
		this.tipKorisnika = tipKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.sifraKorisnika = sifraKorisnika;
		this.registrovan = registrovan;
		this.telefonKorisnika = tel;
		this.email = email;
	}
	public Korisnik(TipKorisnika tipKorisnika, String korisnickoIme, String sifraKorisnika) {
		super();
		this.tipKorisnika = tipKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.sifraKorisnika = sifraKorisnika;
	}
	public Korisnik(){};

	public Korisnik(TipKorisnika tipKorisnika, String korisnickoIme, String sifraKorisnika, Long telefonKorisnika,
			String email, Boolean registrovan, String napomena) {
		super();
		this.tipKorisnika = tipKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.sifraKorisnika = sifraKorisnika;
		this.telefonKorisnika = telefonKorisnika;
		this.email = email;
		this.registrovan = registrovan;
		this.napomena = napomena;
	}
	public Korisnik(String korisnickoIme2) {
		this.korisnickoIme = korisnickoIme2;
	}
	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifraKorisnika() {
		return sifraKorisnika;
	}

	public void setSifraKorisnika(String sifraKorisnika) {
		this.sifraKorisnika = sifraKorisnika;
	}
	
	public Boolean getRegistrovan() {
		return registrovan;
	}
	public void setRegistrovan(Boolean registrovan) {
		this.registrovan = registrovan;
	}
	public Long getTelefonKorisnika() {
		return telefonKorisnika;
	}
	public void setTelefonKorisnika(Long telefonKorisnika) {
		this.telefonKorisnika = telefonKorisnika;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	@Override
	public String toString() {
		return getTipKorisnika().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((korisnickoIme == null) ? 0 : korisnickoIme.hashCode());
		result = prime * result + ((registrovan == null) ? 0 : registrovan.hashCode());
		result = prime * result + ((sifraKorisnika == null) ? 0 : sifraKorisnika.hashCode());
		result = prime * result + ((tipKorisnika == null) ? 0 : tipKorisnika.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Korisnik other = (Korisnik) obj;
		if (korisnickoIme == null) {
			if (other.korisnickoIme != null)
				return false;
		} else if (!korisnickoIme.equals(other.korisnickoIme))
			return false;
		if (registrovan == null) {
			if (other.registrovan != null)
				return false;
		} else if (!registrovan.equals(other.registrovan))
			return false;
		if (sifraKorisnika == null) {
			if (other.sifraKorisnika != null)
				return false;
		} else if (!sifraKorisnika.equals(other.sifraKorisnika))
			return false;
		if (tipKorisnika != other.tipKorisnika)
			return false;
		return true;
	}
	@Override
	public String ispisiImePretime() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
