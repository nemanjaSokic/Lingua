package com.lingua.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.util.net.AbstractEndpoint.Acceptor.AcceptorState;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


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
	@OneToMany(mappedBy="kurs",cascade=CascadeType.REMOVE)
	@JsonProperty(access=Access.WRITE_ONLY)
	protected List<Ucenik> ucenici = new ArrayList<Ucenik>();
	@OneToMany(mappedBy="kurs",cascade=CascadeType.REMOVE)
	@JsonProperty(access=Access.WRITE_ONLY)
	protected List<Test>testovi = new ArrayList<>();
	
	public Kurs(){
		testovi = new ArrayList<>();
		ucenici = new ArrayList<>();
	}
	
	public Kurs(Nastavnik nastavnik, TipKursa tip) {
		this.tipKursa = tip;
		this.nastavnik = nastavnik;
		this.ucenici = new ArrayList<Ucenik>();
		this.testovi = new ArrayList<>();
	}
	public Kurs(Nastavnik nastavnik, TipKursa tip,List<Ucenik> ucenici, List<Test> testovi) {
		this.tipKursa = tip;
		this.nastavnik = nastavnik;
		this.ucenici = ucenici;
		this.testovi = testovi;
	}
	//Dodavanje ucenika na kurs. Ucenik se dodaje u listu i
	//provera ako ucenik NE POHADJA kurs, setuje mu dati kurs automatski
	public void addUcenik(Ucenik ucenik){
		this.getUcenici().add(ucenik);
		if(ucenik.getKurs()!=this){
			ucenik.setKurs(this);
		}
	}
	
	public void addTest(Test test){
		this.getTestovi().add(test);
		if(test.getKurs()!=this){
			test.setKurs(this);
		}
	}
	
	public void removeUcenik(Ucenik ucenik){
		ucenik.setKurs(null);
		this.ucenici.remove(ucenik);
	}
	
	
	public int getIdKursa() {
		return idKursa;
	}

	public void setIdKursa(int idKursa) {
		this.idKursa = idKursa;
	}
	@JsonIgnore
	public List<Test> getTestovi() {
		return testovi;
	}

	public void setTestovi(List<Test> testovi) {
		this.testovi = testovi;
	}

	public int getId() {
		return idKursa;
	}

	public void setId(int id) {
		this.idKursa = id;
	}
	@JsonIgnore
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
