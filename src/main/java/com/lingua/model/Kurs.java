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
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name="tblKursevi")
@JsonSerialize
public class Kurs {
	
	@Id
	@Column(name="id_kursa")
	@GeneratedValue
	protected int idKursa;
	@Column(name="cena")
	protected int cena;
	@OneToOne
	protected Nastavnik nastavnik;
	@OneToOne
	@JsonIgnore
	protected Jezik jezik;
	@OneToOne
	protected Nivo nivo;
	@OneToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable (name = "tbl_pohadjanja" , joinColumns = @JoinColumn(name = "indeks"), inverseJoinColumns=@JoinColumn(name = "idKursa"))
	protected List<Ucenik> ucenici = new ArrayList<Ucenik>();
	
	public Kurs(){}
	
	public Kurs(int cena, Nastavnik nastavnik, Nivo nivo) {
		super();
		this.cena = cena;
		this.nastavnik = nastavnik;
		this.jezik = nastavnik.getPredaje();
		this.nivo = nivo;
		ucenici = new ArrayList<Ucenik>();
	}
	public Kurs(int cena, Nastavnik nastavnik, Nivo nivo, List<Ucenik> ucenici) {
		super();
		this.cena = cena;
		this.nastavnik = nastavnik;
		this.jezik = nastavnik.getPredaje();
		this.nivo = nivo;
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
		this.ucenici.remove(ucenik.getIndeks());
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
