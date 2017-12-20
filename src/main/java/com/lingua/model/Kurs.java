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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tblKursevi")
@JsonSerialize
public class Kurs {
	
	@Id
	@Column(name="idKursa")
	@GeneratedValue
	protected int idKursa;
	@OneToOne
	protected Nastavnik nastavnik;
	@OneToOne
	protected TipKursa tipKursa;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	@JoinTable (name = "tbl_pohadjanja" , inverseJoinColumns = @JoinColumn(name = "korisnicko_ime"), joinColumns=@JoinColumn(name = "idKursa"))
	protected List<Ucenik> ucenici = new ArrayList<Ucenik>();
	
	public Kurs(){}
	
	public Kurs(Nastavnik nastavnik, TipKursa tip) {
		this.tipKursa = tip;
		this.nastavnik = nastavnik;
		ucenici = new ArrayList<Ucenik>();
	}
	public Kurs(Nastavnik nastavnik, TipKursa tip,List<Ucenik> ucenici) {
		this.tipKursa = tip;
		this.nastavnik = nastavnik;
		this.ucenici = ucenici;
	}
	//Dodavanje ucenika na kurs. Ucenik se dodaje u listu i
	//provera ako ucenik NE POHADJA kurs, setuje mu dati kurs automatski
	public void addUcenik(Ucenik ucenik){
		this.getUcenici().add(ucenik);
		if(ucenik.getKurs()!=this){
			ucenik.setKurs(this);
		}
	}
	
	public void removeUcenik(Ucenik ucenik){
		ucenik.setKurs(null);
		this.ucenici.remove(ucenik);
	}
	
	
	public int getId() {
		return idKursa;
	}

	public void setId(int id) {
		this.idKursa = id;
	}

	public List<Ucenik> getUcenici() {
		return ucenici;
	}
	public void setUcenici(List<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipKursa getTipKursa() {
		return tipKursa;
	}

	public void setTipKursa(TipKursa tipKursa) {
		this.tipKursa = tipKursa;
	}
	
	
	
	
	
	
	
	
	
	
	
}
