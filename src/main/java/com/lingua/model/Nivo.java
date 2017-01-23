package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblNivoi")
public class Nivo {
	
	@Id
	@Column(name="id")
	protected int idNivo;
	@Column(name="naziv")
	protected String nazivNivoa;
	
	public Nivo(int idNivo, String nazivNivoa) {
		super();
		this.idNivo = idNivo;
		this.nazivNivoa = nazivNivoa;
	}
	@Override
	public String toString() {
		return "Nivo [nazivNivoa=" + nazivNivoa + "]";
	}
	public int getIdNivo() {
		return idNivo;
	}
	public void setIdNivo(int idNivo) {
		this.idNivo = idNivo;
	}
	public String getNazivNivoa() {
		return nazivNivoa;
	}
	public void setNazivNivoa(String nazivNivoa) {
		this.nazivNivoa = nazivNivoa;
	}
	
	
}
