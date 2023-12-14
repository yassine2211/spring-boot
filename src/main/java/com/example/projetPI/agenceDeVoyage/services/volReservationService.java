package com.example.projetPI.agenceDeVoyage.services;

import java.util.List;

import com.example.projetPI.agenceDeVoyage.Models.volReservation;

public interface volReservationService {

	public List<volReservation> getAllvolReservations();

	public volReservation getvolReservationById(Long id);
	
	public void deletevolReservation(Long id);

	public volReservation updatevolReservation(volReservation v);

	public volReservation addvolReservation(volReservation v);
}
