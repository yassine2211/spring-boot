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
import com.example.projetPI.agenceDeVoyage.services.volService;

@RequestMapping("api/vols")
@CrossOrigin("*")
@RestController
public class volController {

	@Autowired
	private volService volService;
	
	
	@GetMapping
	public List<vol> getAllvoles(){
		return volService.getAllvols();
	}
	
	@GetMapping("/{id}")
	public vol getvol(@PathVariable (name = "id") Long id) {
		return volService.getvolById(id);
	}
	
	@GetMapping("/vol/{nom}")
	public List<vol> getvolByName(@PathVariable (name = "nom") String nom) {
		return volService.getvolByName(nom);
	}
	
	
	@DeleteMapping("/{x}")
	public void deletevolById(@PathVariable (name = "x") Long x) {
	 volService.deletevol(x);}
	
	
	
	@PutMapping
	public vol Editvol(@RequestBody vol m) {
		return volService.updatevol(m);
	}
	
	@PostMapping
	public vol addvol(@RequestBody vol m) {
		return volService.addvol(m);
	}

}
