package com.example.projetPI.agenceDeVoyage.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetPI.agenceDeVoyage.Models.offreReservation;
import com.example.projetPI.agenceDeVoyage.repositories.offreReservationRepository;
import com.example.projetPI.agenceDeVoyage.services.offreReservationService;

@Service
public class offreReservationServiceImpl implements offreReservationService{

	@Autowired
	private offreReservationRepository offreResRepo;
	
	@Override
	public List<offreReservation> getAlloffreReservations() {
		// TODO Auto-generated method stub
		return offreResRepo.findAll();
	}

	@Override
	public offreReservation getoffreReservationById(Long id) {
		// TODO Auto-generated method stub
		 Optional<offreReservation> o= offreResRepo.findById(id);	
	     return o.isPresent() ? o.get() :null;
	}

	@Override
	public void deleteoffreReservation(Long id) {
		// TODO Auto-generated method stub
		offreResRepo.deleteById(id);
		
	}

	@Override
	public offreReservation updateoffreReservation(offreReservation o) {
		// TODO Auto-generated method stub
		return offreResRepo.save(o);
	}

	@Override
	public offreReservation addoffreReservation(offreReservation o) {
		// TODO Auto-generated method stub
		return offreResRepo.save(o);
	}

}
