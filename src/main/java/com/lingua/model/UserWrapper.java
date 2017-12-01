package com.lingua.model;

public class UserWrapper {
	
	private Korisnik korisnik;
	private Nastavnik nastavnik;
	private Ucenik ucenik;
	
	public UserWrapper(Korisnik korisnik, Nastavnik nastavnik, Ucenik ucenik) {
		super();
		this.korisnik = korisnik;
		this.nastavnik = nastavnik;
		this.ucenik = ucenik;
	}
	
	public UserWrapper(){}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	};
	
}
