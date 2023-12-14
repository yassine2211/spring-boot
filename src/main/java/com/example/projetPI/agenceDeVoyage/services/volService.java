package com.example.projetPI.agenceDeVoyage.services;

import java.util.List;

import com.example.projetPI.agenceDeVoyage.Models.vol;

public interface volService {

	public List<vol> getAllvols();

	public vol getvolById(Long id);
	
	public List<vol> getvolByName(String n);
	
	public void deletevol(Long id);

	public vol updatevol(vol v);

	public vol addvol(vol v);
}
