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

import com.example.projetPI.agenceDeVoyage.Models.vol;
import com.example.projetPI.agenceDeVoyage.Models.volReservation;
import com.example.projetPI.agenceDeVoyage.services.volReservationService;
import com.example.projetPI.agenceDeVoyage.services.volService;

@RequestMapping("api/volReservation")
@CrossOrigin("*")
@RestController
public class volReservationController {
	@Autowired
	private volReservationService volReservationService;
	
	@Autowired
	private volService volService;
	
	@GetMapping
	public List<volReservation> getAllvolReservationes(){
		return volReservationService.getAllvolReservations();
	}
	
	@GetMapping("/{id}")
	public volReservation getvolReservation(@PathVariable (name = "id") Long id) {
		return volReservationService.getvolReservationById(id);
	}
	
	
	@DeleteMapping("/{x}")
	public void deletevolReservationById(@PathVariable (name = "x") Long x) {
	 volReservationService.deletevolReservation(x);}
	
	@PostMapping("/{volId}")
	public volReservation addvolReservation(@RequestBody volReservation vr , @PathVariable(name = "volId") Long   volId) {	
		vol v = volService.getvolById(volId);
		vr.setVol(v);
		return volReservationService.addvolReservation(vr);
	}
	
	
	@PutMapping
	public volReservation EditvolReservation(@RequestBody volReservation or) {
		return volReservationService.updatevolReservation(or);
	}
}
