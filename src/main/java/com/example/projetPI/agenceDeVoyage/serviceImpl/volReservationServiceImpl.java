package com.example.projetPI.agenceDeVoyage.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetPI.agenceDeVoyage.Models.volReservation;
import com.example.projetPI.agenceDeVoyage.repositories.volReservationRepository;
import com.example.projetPI.agenceDeVoyage.services.volReservationService;

@Service
public class volReservationServiceImpl implements volReservationService{

	@Autowired
	private volReservationRepository volResRepo;
	
	@Override
	public List<volReservation> getAllvolReservations() {
		// TODO Auto-generated method stub
		return volResRepo.findAll();
	}

	@Override
	public volReservation getvolReservationById(Long id) {
		// TODO Auto-generated method stub
		 Optional<volReservation> o= volResRepo.findById(id);	
	     return o.isPresent() ? o.get() :null;
	}

	@Override
	public void deletevolReservation(Long id) {
		// TODO Auto-generated method stub
		volResRepo.deleteById(id);
	}

	@Override
	public volReservation updatevolReservation(volReservation v) {
		// TODO Auto-generated method stub
		return volResRepo.save(v);
	}

	@Override
	public volReservation addvolReservation(volReservation v) {
		// TODO Auto-generated method stub
		return volResRepo.save(v);
	}

}
