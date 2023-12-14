package com.example.projetPI.agenceDeVoyage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetPI.agenceDeVoyage.Models.destination;

@Repository
public interface destinationRepository  extends JpaRepository<destination, Long> {
    List<destination> findByName(String name);

}
