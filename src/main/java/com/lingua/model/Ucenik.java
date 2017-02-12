package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblUcenici")
public class Ucenik extends Osoba {
	
	@Id
	@Column
	protected String indeks;
	@ManyToOne(fetch=FetchType.LAZY)
	protected Kurs kurs;
	
	
	public Ucenik(String ime, String prezime, int jmbg) {
		super(ime, prezime, jmbg);
	}

	public Ucenik(String ime, String prezime, int jmbg, Kurs kurs, String index) {
		super(ime, prezime, jmbg);
		this.kurs = kurs;
		this.indeks = index;
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

	@Override
	public String ispisiImePretime() {
		return "Ucenik " + getIme() + " " + getPrezime();
	}
	
}