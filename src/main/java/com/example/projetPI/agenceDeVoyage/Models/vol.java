package com.example.projetPI.agenceDeVoyage.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class vol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VOL_ID")
	private Long id; 
	private String depart ;
	@Column(name="arrivee")
	private String name;
	private String classe ;
	private float prix;
	private Date dateDep;
	
	
	
	
	public vol() {
	}

	

	public vol( String depart, String name, String classe, float prix, Date dateDep) {
		this.depart = depart;
		this.name = name;
		this.classe = classe;
		this.prix = prix;
		this.dateDep = dateDep;
	}


	

	public String getClasse() {
		return classe;
	}



	public void setClasse(String classe) {
		this.classe = classe;
	}



	public Long getId() {
		return id;
	}
	
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public Date getDateDep() {
		return dateDep;
	}
	public void setDateDep(Date dateDep) {
		this.dateDep = dateDep;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "vol [id=" + id + ", depart=" + depart + ", name=" + name + ", classe=" + classe + ", prix=" + prix
				+ ", dateDep=" + dateDep + "]";
	}


}
