package com.example.projetPI.agenceDeVoyage.Models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class offreReservation {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="offreReservation_ID")
	private Long id ;
	@ManyToOne
	@JoinColumn(name = "OFFRE_ID", nullable = true)
	private offre offre;
	private int nbPersonne;
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public offreReservation() {
	}

	public offreReservation(Long id, com.example.projetPI.agenceDeVoyage.Models.offre offre, int nbPersonne) {
		this.id = id;
		this.offre = offre;
		this.nbPersonne = nbPersonne;
	}

	public Long getId() {
		return id;
	}

	public offre getOffre() {
		return offre;
	}
	public void setOffre(offre offre) {
		this.offre = offre;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	@Override
	public String toString() {
		return "offreReservation [id=" + id + ", offre=" + offre + ", nbPersonne=" + nbPersonne + "]";
	}
	
	
	
	
	
}
