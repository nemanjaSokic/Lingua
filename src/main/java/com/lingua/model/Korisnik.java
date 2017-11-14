package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblKorisnici")
public class Korisnik {

	@Column(name="tip")
	protected TipKorisnika tipKorisnika;
	@Id
	@Column(name="korisnicko_ime")
	protected String korisnickoIme;
	@Column(name="sifra")
	protected String sifraKorisnika;

	public Korisnik(TipKorisnika tipKorisnika, String korisnickoIme, String sifraKorisnika) {
		super();
		this.tipKorisnika = tipKorisnika;
		this.korisnickoIme = korisnickoIme;
		this.sifraKorisnika = sifraKorisnika;
	}
	public Korisnik(){};

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
	
	@Override
	public String toString() {
		return getTipKorisnika().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((korisnickoIme == null) ? 0 : korisnickoIme.hashCode());
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
		if (sifraKorisnika == null) {
			if (other.sifraKorisnika != null)
				return false;
		} else if (!sifraKorisnika.equals(other.sifraKorisnika))
			return false;
		if (tipKorisnika == null) {
			if (other.tipKorisnika != null)
				return false;
		} else if (!tipKorisnika.equals(other.tipKorisnika))
			return false;
		return true;
	}
	
	
}
