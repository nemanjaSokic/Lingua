package com.lingua.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblUplate")
public class Uplata {
	@Id
	@Column(name="broj_uplatnice")
	@GeneratedValue
	protected int uplatnicaBr;
	@Column
	protected int uplata;
	@Column
	Date datum;
	@OneToOne(fetch=FetchType.LAZY)
	Ucenik ucenik;
	
	
	public Uplata(int uplatnicaBr, int uplata, Date datum) {
		super();
		this.uplatnicaBr = uplatnicaBr;
		this.uplata = uplata;
		this.datum = datum;
	}
	
	
	public Uplata(int uplatnicaBr, int uplata, Date datum, Ucenik ucenik) {
		super();
		this.uplatnicaBr = uplatnicaBr;
		this.uplata = uplata;
		this.datum = datum;
		this.ucenik = ucenik;
	}


	@Override
	public String toString() {
		return "Uplata " + uplata + "\tdatum " + datum + " " + ucenik.getKurs().getJezik().getNaziv() + ucenik.getKurs().nivo.nazivNivoa + uplatnicaBr +"\n";
	}
	public int getUplatnicaBr() {
		return uplatnicaBr;
	}
	public void setUplatnicaBr(int uplatnicaBr) {
		this.uplatnicaBr = uplatnicaBr;
	}
	public int getUplata() {
		return uplata;
	}
	public void setUplata(int uplata) {
		this.uplata = uplata;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public Ucenik getUcenik() {
		return ucenik;
	}


	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	
}
