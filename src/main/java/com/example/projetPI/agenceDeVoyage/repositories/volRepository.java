package com.example.projetPI.agenceDeVoyage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetPI.agenceDeVoyage.Models.vol;

@Repository
public interface volRepository extends JpaRepository<vol, Long>{

    List<vol> findByName(String name);

}
