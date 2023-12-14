package com.example.projetPI.agenceDeVoyage.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetPI.agenceDeVoyage.Models.offre;
import com.example.projetPI.agenceDeVoyage.repositories.offreRepository;
import com.example.projetPI.agenceDeVoyage.services.offreService;

@Service
public class offreServiceImpl implements offreService{

	@Autowired
	private offreRepository offreRepo;
	
	@Override
	public List<offre> getAlloffres() {
		// TODO Auto-generated method stub
		return offreRepo.findAll();
	}

	@Override
	public offre getoffreById(Long id) {
		// TODO Auto-generated method stub
		 Optional<offre> o= offreRepo.findById(id);	
	     return o.isPresent() ? o.get() :null;
	}

	@Override
	public List<offre> getoffreByName(String n) {
		// TODO Auto-generated method stub
		return offreRepo.findByName(n);
	}

	@Override
	public void deleteoffre(Long id) {
		// TODO Auto-generated method stub
		offreRepo.deleteById(id);
		
	}

	@Override
	public offre updateoffre(offre o) {
		// TODO Auto-generated method stub
		return offreRepo.save(o);
	}

	@Override
	public offre addoffre(offre o) {
		// TODO Auto-generated method stub
		return offreRepo.save(o);
	}

}
