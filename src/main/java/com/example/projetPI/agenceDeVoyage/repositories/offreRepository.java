package com.example.projetPI.agenceDeVoyage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetPI.agenceDeVoyage.Models.offre;


@Repository
public interface offreRepository extends JpaRepository<offre, Long> {
    List<offre> findByName(String name);

}
