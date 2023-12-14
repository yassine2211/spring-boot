package com.example.projetPI.agenceDeVoyage.services;

import java.util.List;

import com.example.projetPI.agenceDeVoyage.Models.destination;


public interface destinationService {

	public List<destination> getAlldestinations();

	public destination getdestinationById(Long id);
	
	public List<destination> getdestinationByName(String n);
	
    public boolean isNomDestinationExist(String nom);


	public void deletedestination(Long id);

	public destination updatedestination(destination d);

	public destination addDestination(destination d);
}
