package com.lingua.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblKursevi")
public class Kurs {
	
	@Id
	@Column(name="id_kursa")
	@GeneratedValue
	protected int idKursa;
	@Column(name="cena")
	protected int cena;
	@OneToOne(fetch=FetchType.LAZY)
	protected Nastavnik nastavnik;
	@OneToOne(fetch=FetchType.LAZY)
	protected Jezik jezik;
	@OneToOne(fetch=FetchType.LAZY)
	protected Nivo nivo;
	@OneToMany(mappedBy="kurs",cascade=CascadeType.REMOVE)
	protected List<Ucenik> ucenici = new ArrayList<Ucenik>();
	
	public Kurs(int idKursa, int cena, Nastavnik nastavnik, Jezik jezik, Nivo nivo) {
		super();
		this.idKursa = idKursa;
		this.cena = cena;
		this.nastavnik = nastavnik;
		this.jezik = jezik;
		this.nivo = nivo;
		ucenici = new ArrayList<Ucenik>();
	}
	public Kurs(int idKursa, int cena, Nastavnik nastavnik, Jezik jezik, Nivo nivo, List<Ucenik> ucenici) {
		super();
		this.idKursa = idKursa;
		this.cena = cena;
		this.nastavnik = nastavnik;
		this.jezik = jezik;
		this.nivo = nivo;
		this.ucenici = ucenici;
	}
	public List<Ucenik> getUcenici() {
		return ucenici;
	}
	public void setUcenici(List<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}
	@Override
	public String toString() {
		return "Kurs " + cena + ", jezik " + jezik.getNaziv() + nivo.nazivNivoa +  ", "
				+ nivo + "nivo." + "\n";
	}
	public int getIdKursa() {
		return idKursa;
	}
	public void setIdKursa(int idKursa) {
		this.idKursa = idKursa;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	public Jezik getJezik() {
		return jezik;
	}
	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}
	public Nivo getNivo() {
		return nivo;
	}
	public void setNivo(Nivo nivo) {
		this.nivo = nivo;
	}
	
	
	
	
	
	
	
	
	
	
	
}
