package com.example.projetPI.agenceDeVoyage.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.projetPI.agenceDeVoyage.services.offreService;
import com.example.projetPI.agenceDeVoyage.Models.destination;
import com.example.projetPI.agenceDeVoyage.Models.offre;
import com.example.projetPI.agenceDeVoyage.services.destinationService;


@RequestMapping("api/offres")
@CrossOrigin("*")
@RestController
public class offreController {

	@Autowired
	private offreService offreService;
	
	@Autowired
	private destinationService destinationService;
	
	@GetMapping
	public List<offre> getAlloffrees(){
		return offreService.getAlloffres();
	}
	
	@GetMapping("/{id}")
	public offre getoffre(@PathVariable (name = "id") Long id) {
		return offreService.getoffreById(id);
	}
	
	@GetMapping("offre/{nom}")
	public List<offre> getoffreByName(@PathVariable (name = "nom") String nom) {
		return offreService.getoffreByName(nom);
	}
	
	@DeleteMapping("/{x}")
	public void deleteoffreById(@PathVariable (name = "x") Long x) {
	 offreService.deleteoffre(x);}
	
	
	  @PutMapping("/{DestinationId}") public ResponseEntity<offre>
	  Editoffre(@RequestParam("img") MultipartFile img,
	 @RequestParam("nom") String nom,
	  @RequestParam("duree") String duree,
	  @RequestParam("id") Long id,
	 @RequestParam("descr") String descr,
	  @RequestParam("date") Date date,@RequestParam("prix") float prix ,
	 @PathVariable (name = "DestinationId") Long DestinationId){
	 try {
	 byte[] imageData = img.getBytes(); 
	 // Obtenez offre à partir de la base de données en utilisant l'ID 
	  offre existingOffre =offreService.getoffreById(id); 
	 // Mettez à jour les champs de l'offre 
	  existingOffre.setName(nom);
	 existingOffre.setDateDeb(date); 
	 existingOffre.setPrix(prix);
	 existingOffre.setDescription(descr); 
	 existingOffre.setDuree(duree);
	 existingOffre.setImage(imageData); 
	 destination d = destinationService.getdestinationById(DestinationId);
	 existingOffre.setDestination(d);
	 // Enregistrez l'offre mise à jour dans la base de données 
	  offre updatedOffre  = offreService.updateoffre(existingOffre);
	  return new ResponseEntity<>(updatedOffre, HttpStatus.OK);
	 
	 } catch (IOException e) { return new
	 ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 
	  	
	@PostMapping("/{DestinationId}")
	public ResponseEntity<offre> addoffre(@RequestParam("img") MultipartFile img,
			@RequestParam("nom") String nom,
			@RequestParam("duree") String duree,
			@RequestParam("descr") String descr,
			@RequestParam("date") Date date,@RequestParam("prix") float prix ,
            @PathVariable (name = "DestinationId") Long DestinationId) {
	    try {
	        // Sauvegarde de l'image dans le système de stockage (par exemple, serveur de fichiers, AWS S3, etc.)
	        // Votre logique pour sauvegarder imageData, nom et pays dans la base de données
	        // ...
	        byte[] imageData = img.getBytes();

	        // Création de l'objet destination avec les données sauvegardées
	        offre savedOffre = new offre();
	        savedOffre.setName(nom);
	        savedOffre.setDateDeb(date);
	        savedOffre.setPrix(prix);
	        savedOffre.setDescription(descr);
	        savedOffre.setDuree(duree);
	        savedOffre.setImage(imageData);	        
	        destination d = destinationService.getdestinationById(DestinationId);
	        savedOffre.setDestination(d);
	        // Enregistrez la destination dans la base de données
	        savedOffre = offreService.addoffre(savedOffre);

	        return new ResponseEntity<>(savedOffre, HttpStatus.CREATED);
            
	    } catch (IOException e) {
	        // Gestion des erreurs liées à la manipulation de fichiers
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
