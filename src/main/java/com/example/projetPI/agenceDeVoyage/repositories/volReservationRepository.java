package com.example.projetPI.agenceDeVoyage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetPI.agenceDeVoyage.Models.volReservation;


@Repository
public interface volReservationRepository extends JpaRepository<volReservation, Long>{

}
