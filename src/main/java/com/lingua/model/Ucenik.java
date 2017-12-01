package com.lingua.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tblUcenici")
public class Ucenik extends Osoba {
	
	@Id
	@Column
	@GenericGenerator(name = "id_indexgenerator", strategy = "com.lingua.support.UcenikIdGenerator")
	@GeneratedValue(generator = "id_indexgenerator")
	protected String indeks;
	@Column
	protected Boolean status;
	@ManyToOne(targetEntity=Kurs.class, fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	protected Kurs kurs;
	@OneToMany(cascade={CascadeType.ALL,CascadeType.REMOVE})
	@JsonIgnore
	@JoinTable (name = "tbl_uplatnice" , joinColumns = @JoinColumn(name = "indeks"),inverseJoinColumns=@JoinColumn(name = "broj_uplatnice"))
	protected List<Uplata> uplate;
	@OneToOne
	@JoinTable(name="tbl_nalogUcenika", joinColumns = @JoinColumn(name= "indeks"), inverseJoinColumns=@JoinColumn(name="korisnicko_ime"))
	protected Korisnik korisnik;
	
	public Ucenik() {this.uplate=new ArrayList<Uplata>();}
	public Ucenik(String ime, String prezime, String index){
		super(ime,prezime);
		this.indeks = index;
		this.uplate=new ArrayList<Uplata>();
		this.status=checkStatus();
		}
	public Ucenik(String ime, String prezime,boolean status, Korisnik k) {
		super(ime, prezime);
		this.status = status;
		this.korisnik = k;
		this.uplate=new ArrayList<Uplata>();
	}

	public Ucenik(String ime, String prezime, Kurs kurs, String index) {
		super(ime, prezime);
		this.kurs = kurs;
		this.indeks = index;
	}
	
	public boolean checkStatus(){
		int sum = 0;
		for(Uplata uplata : this.uplate){
			sum+=uplata.getUplata();
			if(sum >= this.getKurs().getCena()){
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

	public List<Uplata> getUplate() {
		return uplate;
	}
	public void setUplate(List<Uplata> uplate) {
		this.uplate = uplate;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	@Override
	public String ispisiImePretime() {
		return "Ucenik " + getIme() + " " + getPrezime();
	}
	
}