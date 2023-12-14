package com.example.projetPI.agenceDeVoyage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetPI.agenceDeVoyage.Models.offre;
import com.example.projetPI.agenceDeVoyage.Models.offreReservation;
import com.example.projetPI.agenceDeVoyage.services.offreReservationService;
import com.example.projetPI.agenceDeVoyage.services.offreService;

@RequestMapping("api/offreReservation")
@CrossOrigin("*")
@RestController
public class offreReservationController {
	@Autowired
	private offreReservationService offreReservationService;
	
	@Autowired
	private offreService offreService;
	
	@GetMapping
	public List<offreReservation> getAlloffreReservationes(){
		return offreReservationService.getAlloffreReservations();
	}
	
	@GetMapping("/{id}")
	public offreReservation getoffreReservation(@PathVariable (name = "id") Long id) {
		return offreReservationService.getoffreReservationById(id);
	}
	
	
	@DeleteMapping("/{x}")
	public void deleteoffreReservationById(@PathVariable (name = "x") Long x) {
	 offreReservationService.deleteoffreReservation(x);}
	
	@PostMapping("/{offreId}")
	public offreReservation addoffreReservation(@RequestBody offreReservation or , @PathVariable (name = "offreId") Long offreId) {	
		offre o = offreService.getoffreById(offreId);
		or.setOffre(o);
		return offreReservationService.addoffreReservation(or);
	}
	
	
	@PutMapping
	public offreReservation EditoffreReservation(@RequestBody offreReservation or) {
		return offreReservationService.updateoffreReservation(or);
	}
}
