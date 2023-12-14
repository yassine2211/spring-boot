package com.example.projetPI.agenceDeVoyage.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetPI.agenceDeVoyage.Models.vol;
import com.example.projetPI.agenceDeVoyage.Models.volReservation;
import com.example.projetPI.agenceDeVoyage.repositories.volRepository;
import com.example.projetPI.agenceDeVoyage.services.volService;

@Service
public class volServiceImpl  implements volService{

	@Autowired
	private volRepository volRepo;
	
	@Override
	public List<vol> getAllvols() {
		// TODO Auto-generated method stub
		return volRepo.findAll();
	}

	@Override
	public vol getvolById(Long id) {
		// TODO Auto-generated method stub
		 Optional<vol> o= volRepo.findById(id);	
	     return o.isPresent() ? o.get() :null;
	}

	@Override
	public void deletevol(Long id) {
		// TODO Auto-generated method stub
		volRepo.deleteById(id);
	}

	@Override
	public vol updatevol(vol v) {
		// TODO Auto-generated method stub
		return volRepo.save(v);
	}

	@Override
	public vol addvol(vol v) {
		// TODO Auto-generated method stub
		return volRepo.save(v);
	}

	@Override
	public List<vol> getvolByName(String n) {
		// TODO Auto-generated method stub
		return volRepo.findByName(n);
	}

}
