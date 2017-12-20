package com.lingua.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tblTipKursa")
@JsonSerialize
@Inheritance(strategy = InheritanceType.JOINED)
public class TipKursa {

	
	@Id
	@Column(name="id_tipa")
	@GeneratedValue
	protected int id;
	@Column(name="cena")
	protected int cena;
	@OneToOne
	protected Jezik jezik;
	@OneToOne
	protected Nivo nivo;
	
	public TipKursa(){};
	public TipKursa(int cena, Nivo nivo) {
		this.cena = cena;
		this.nivo = nivo;
	}
	public TipKursa(int cena, Jezik jezik, Nivo nivo) {
		super();
		this.cena = cena;
		this.jezik = jezik;
		this.nivo = nivo;
	}
	
	public int getIdKursa() {
		return id;
	}
	public void setIdKursa(int idKursa) {
		this.id = idKursa;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
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
