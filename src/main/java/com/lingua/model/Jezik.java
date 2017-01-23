package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblJezici")
public class Jezik {

	@Id
	@Column(name="id")
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
		this.idJezika = idGenerator(naziv);
	}

	private String idGenerator(String naziv2) {
		String id = naziv2.substring(0, 3);
		return id;
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
