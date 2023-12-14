package com.example.projetPI.agenceDeVoyage.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetPI.agenceDeVoyage.Models.destination;
import com.example.projetPI.agenceDeVoyage.repositories.destinationRepository;
import com.example.projetPI.agenceDeVoyage.services.destinationService;

@Service
public class destinationServiceImpl implements destinationService{
	
	@Autowired
	private destinationRepository destinationRepo;

	@Override
	public List<destination> getAlldestinations() {
		return destinationRepo.findAll();
	}

	@Override
	public destination getdestinationById(Long id) {
		// TODO Auto-generated method stub
		 Optional<destination> d= destinationRepo.findById(id);	
	     return d.isPresent() ? d.get() :null;
	}

	@Override
	public List<destination> getdestinationByName(String n) {
		
		return destinationRepo.findByName(n);
	}

	@Override
	public void deletedestination(Long id) {
		
		destinationRepo.deleteById(id);
		
	}

	@Override
	public destination updatedestination(destination d) {
		// TODO Auto-generated method stub
		return destinationRepo.save(d);
	}

	@Override
	public destination addDestination(destination d) {
		// TODO Auto-generated method stub
		return destinationRepo.save(d);
	}
	
	@Override
    public boolean isNomDestinationExist(String nom) {
        List<destination> destinations = destinationRepo.findByName(nom);
        return !destinations.isEmpty();
    }

}
