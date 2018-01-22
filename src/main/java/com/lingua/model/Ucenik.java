package com.lingua.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lingua.support.UcenikIdGenerator;

@Entity
@Table(name="tblUcenici")
@JsonSerialize
public class Ucenik extends Korisnik {
	
	@Column
	protected String indeks;
	@Column
	protected Boolean status;
	@ManyToOne(fetch=FetchType.EAGER)
	//@JsonBackReference
	protected Kurs kurs;
	@OneToMany(mappedBy="ucenik",cascade=CascadeType.REMOVE)
	@JsonProperty(access=Access.WRITE_ONLY)
	protected List<Uplata> uplate;
	@OneToMany(mappedBy="ucenik",cascade=CascadeType.REMOVE)
	protected List<Ocena> ocene;
	
	
	public Ucenik() {
		this.uplate=new ArrayList<Uplata>();
		this.ocene = new ArrayList<>();
	}
	
	public Ucenik(String ime, String prezime, TipKorisnika tipKorisnika, String korisnickoIme, String sifraKorisnika,
			Long telefonKorisnika, String email, Boolean registrovan, String napomena, Boolean status,
			Kurs kurs) {
		super(ime, prezime, tipKorisnika, korisnickoIme, sifraKorisnika, telefonKorisnika, email, registrovan,
				napomena);
		this.status = status;
		this.kurs = kurs;
		this.uplate = new ArrayList<>();
		this.ocene = new ArrayList<>();
		this.indeks = UcenikIdGenerator.generate(ime, prezime);
	}

	public boolean checkStatus(){
		int sum = 0;
		for(Uplata uplata : this.uplate){
			sum+=uplata.getUplata();
			if(sum >= this.getKurs().getTipKursa().getCena()){
				return false;
			}
		}
		return true;
	}
	
	public void addUplata(Uplata uplata){
		this.uplate.add(uplata);
		if(uplata.getUcenik() != this){
			uplata.setUcenik(this);
		}
	}
	
	public void addOcena(Ocena ocena){
		this.ocene.add(ocena);
		if(ocena.getUcenik() != this){
			ocena.setUcenik(this);
		}
	}
	@JsonIgnore
	public List<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}

	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public Kurs getKurs() {
		return kurs;
	}
	//Kurs ucenika se setuje kao dati kurs i
	//ako kurs nije null i ako dati kurs nema ucenika automatski se tom kursu dodaje ucenik
	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
		if(kurs != null && !kurs.getUcenici().contains(this)){
			kurs.getUcenici().add(this);
		}
	}
	@JsonIgnore
	public List<Uplata> getUplate() {
		return uplate;
	}
	public void setUplate(List<Uplata> uplate) {
		this.uplate = uplate;
	}

	@Override
	public String ispisiImePretime() {
		return "Ucenik " + getIme() + " " + getPrezime();
	}
	
}