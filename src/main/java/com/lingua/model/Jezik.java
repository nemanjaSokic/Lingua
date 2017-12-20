package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tblJezici")
public class Jezik {

	@Id
	@Column(name="id")
	@GenericGenerator(name = "id_generator", strategy = "com.lingua.support.JezikIdGenerator")
	@GeneratedValue(generator = "id_generator")
	protected String idJezika;
	@Column(name="naziv")
	protected String naziv;

	public Jezik(String idJezika, String naziv) {
		super();
		this.idJezika = idJezika;
		this.naziv = naziv;
	}

	public Jezik(String naziv) {
		super();
		this.naziv = naziv;
		//this.idJezika = idGenerator(naziv);
	}

	@Override
	public String toString() {
		return "Jezik [naziv=" + naziv + "]";
	}

	public Jezik() {
	}

	public String getIdJezika() {
		return idJezika;
	}

	public void setIdJezika(String idJezika) {
		this.idJezika = idJezika;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
