package com.example.projetPI.agenceDeVoyage.Models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class volReservation {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="volReservation_ID")
	private Long id ;
	@ManyToOne
	@JoinColumn(name = "VOL_ID", nullable = true)
	private vol vol;
	private int nbPersonne;
	
	
	public volReservation() {
	}


	public volReservation(Long id, com.example.projetPI.agenceDeVoyage.Models.vol vol, int nbPersonne) {
		this.id = id;
		this.vol = vol;
		this.nbPersonne = nbPersonne;
	}


	public Long getId() {
		return id;
	}
	
	



	public void setId(Long id) {
		this.id = id;
	}


	public vol getVol() {
		return vol;
	}


	public void setVol(vol vol) {
		this.vol = vol;
	}


	public int getNbPersonne() {
		return nbPersonne;
	}


	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}


	@Override
	public String toString() {
		return "volReservation [id=" + id + ", vol=" + vol + ", nbPersonne=" + nbPersonne + "]";
	}
	
}
