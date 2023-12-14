package com.example.projetPI.agenceDeVoyage.controllers;

import java.io.IOException;
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

import com.example.projetPI.agenceDeVoyage.Models.destination;
import com.example.projetPI.agenceDeVoyage.services.destinationService;


@RequestMapping("api/destinations")
@CrossOrigin("*")
@RestController
public class destinationController {
	
	@Autowired
	private destinationService destinationService;
	
	@GetMapping
	public List<destination> getAlldestinationes(){
		return destinationService.getAlldestinations();
	}
	@GetMapping("/{id}")
	public destination getdestination(@PathVariable (name = "id") Long id) {
		return destinationService.getdestinationById(id);
	}
	@GetMapping("/destination/{nom}")
	public List<destination> getdestinationByName(@PathVariable (name = "nom") String nom) {
		return destinationService.getdestinationByName(nom);
	}
	@DeleteMapping("/{x}")
	public void deletedestinationById(@PathVariable (name = "x")  Long x) {
	 destinationService.deletedestination(x);}
	
	
	
	@PutMapping
	public ResponseEntity<destination> Editdestination(@RequestParam("img") MultipartFile img,
	                                                   @RequestParam("nom") String nom,
	                                                   @RequestParam("pays") String pays,
	                                                   @RequestParam("id") Long id) {
	    try {
	    	
	    	if (destinationService.isNomDestinationExist(nom)) {
	        	System.out.println("nom deja exist");
	        	return null;
            }else {
	    	
	        byte[] imageData = img.getBytes();
	        // Obtenez la destination à partir de la base de données en utilisant l'ID
	        destination existingDestination = destinationService.getdestinationById(id);

	        // Mettez à jour les champs de la destination
	        existingDestination.setName(nom);
	        existingDestination.setPays(pays);
	        existingDestination.setImage(imageData);

	        // Enregistrez la destination mise à jour dans la base de données
	        destination updatedDestination = destinationService.updatedestination(existingDestination);

	        return new ResponseEntity<>(updatedDestination, HttpStatus.OK);
            }
	    } catch (IOException e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	  	
	@PostMapping
	public ResponseEntity<destination> adddestination(@RequestPart("img") MultipartFile img,
	                                                 @RequestPart("nom") String nom,
	                                                 @RequestPart("pays") String pays) {
	    try {
	        // Sauvegarde de l'image dans le système de stockage (par exemple, serveur de fichiers, AWS S3, etc.)
	        // Votre logique pour sauvegarder imageData, nom et pays dans la base de données
	        // ...
	        if (destinationService.isNomDestinationExist(nom)) {
	        	System.out.println("nom deja exist");
	        	return null;
            }else {
	        byte[] imageData = img.getBytes();
	        // Création de l'objet destination avec les données sauvegardées
	        destination savedDestination = new destination();
	        savedDestination.setName(nom);
	        savedDestination.setPays(pays);
	        // Assurez-vous que votre entité destination a un champ pour stocker les données de l'image
	        savedDestination.setImage(imageData);
	        // Enregistrez la destination dans la base de données
	        savedDestination = destinationService.addDestination(savedDestination);
	        return new ResponseEntity<>(savedDestination, HttpStatus.CREATED);
            }
	    } catch (IOException e) {
	        // Gestion des erreurs liées à la manipulation de fichiers
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
