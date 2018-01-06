package com.lingua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="tblNivoi")
@JsonSerialize
public class Nivo {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	protected int idNivo;
	@Column(name="naziv")
	protected String nazivNivoa;
	
	public Nivo(){}
	public Nivo(int idNivo, String nazivNivoa) {
		super();
		this.idNivo = idNivo;
		this.nazivNivoa = nazivNivoa;
	}
	public Nivo(String string) {
		this.nazivNivoa=string;
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
