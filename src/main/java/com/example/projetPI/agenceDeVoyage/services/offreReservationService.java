package com.example.projetPI.agenceDeVoyage.services;

import java.util.List;

import com.example.projetPI.agenceDeVoyage.Models.offreReservation;

public interface offreReservationService {

	public List<offreReservation> getAlloffreReservations();

	public offreReservation getoffreReservationById(Long id);
	
	public void deleteoffreReservation(Long id);

	public offreReservation updateoffreReservation(offreReservation o);

	public offreReservation addoffreReservation(offreReservation o);
}
