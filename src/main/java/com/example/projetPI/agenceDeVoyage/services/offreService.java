package com.example.projetPI.agenceDeVoyage.services;

import java.util.List;

import com.example.projetPI.agenceDeVoyage.Models.offre;

public interface offreService {

	public List<offre> getAlloffres();

	public offre getoffreById(Long id);
	
	public List<offre> getoffreByName(String n);

	public void deleteoffre(Long id);

	public offre updateoffre(offre o);

	public offre addoffre(offre o);
}
