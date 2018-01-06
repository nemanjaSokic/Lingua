package com.lingua.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;




@Entity
@Table(name="tblUplate")
@JsonSerialize
public class Uplata {
	@Id
	@Column(name="broj_uplatnice")
	@GeneratedValue
	protected int uplatnicaBr;
	@Column
	protected int uplata;
	@Column
	Date datum;
	@ManyToOne(fetch=FetchType.EAGER)
	//@JsonBackReference
	Ucenik ucenik;
	
	
	public Uplata(){}
	
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

	public Uplata(int uplata, Date datum, Ucenik ucenik) {
		this.uplata = uplata;
		this.datum = datum;
		this.ucenik = ucenik;
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
		if(ucenik != null && !ucenik.getUplate().contains(this)){
			ucenik.getUplate().add(this);
		}
	}
	
}
