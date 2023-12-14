package com.example.projetPI.agenceDeVoyage.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.projetPI.agenceDeVoyage.Models.offre;
import com.example.projetPI.agenceDeVoyage.Models.offreReservation;
import com.example.projetPI.agenceDeVoyage.services.offreReservationService;
import com.example.projetPI.agenceDeVoyage.services.offreService;

@ExtendWith(MockitoExtension.class)
public class offreReservationControllerTest {

    @Mock
    private offreReservationService offreReservationService;

    @Mock
    private offreService offreService;

    @InjectMocks
    private offreReservationController offreReservationController;

    @BeforeEach
    public void setUp() {
        // Initialization if necessary
    }

    @Test
    public void testGetAllOffreReservations() {
        when(offreReservationService.getAlloffreReservations()).thenReturn(Arrays.asList(new offreReservation(), new offreReservation()));
        List<offreReservation> offreReservations = offreReservationController.getAlloffreReservationes();
        assertEquals(2, offreReservations.size());
        // Add other assertions if necessary
    }

    @Test
    public void testGetOffreReservationById() {
        when(offreReservationService.getoffreReservationById(5L)).thenReturn(new offreReservation());
        offreReservation offreRes = offreReservationController.getoffreReservation(5L);
        // Add appropriate assertions
        assertEquals(5L, offreRes.getId());
    }

    @Test
    public void testDeleteOffreReservationById() {
        offreReservationController.deleteoffreReservationById(1L);
        // Add appropriate assertions
    }

    @Test
    public void testAddOffreReservation() {
        // Create an instance of offreReservation with desired parameters
        offreReservation offreResToAdd = new offreReservation();
        offreResToAdd.setId(4L);

        // Mocking the behavior of offreService to return a dummy offre
        when(offreService.getoffreById(anyLong())).thenReturn(new offre());

        // Configure the service behavior for the test
        when(offreReservationService.addoffreReservation(any())).thenReturn(offreResToAdd);

        // Call the method to test with the parameters
        offreReservation addedOffreRes = offreReservationController.addoffreReservation(offreResToAdd, 1L); // Assuming 1L is the offreId

        // Add appropriate assertions
        assertEquals(4L, addedOffreRes.getId());
        // Add other assertions for other added parameters
    }

    @Test
    public void testEditOffreReservation() {
        // Create an instance of offreReservation with desired parameters
        offreReservation offreResToUpdate = new offreReservation();
        offreResToUpdate.setId(1L);

        // Configure the service behavior for the test
        when(offreReservationService.updateoffreReservation(any())).thenReturn(offreResToUpdate);

        // Call the method to test with the parameters
        offreReservation editedOffreRes = offreReservationController.EditoffreReservation(offreResToUpdate);

        // Add appropriate assertions
        assertEquals(1L, editedOffreRes.getId());
        // Add other assertions for other updated parameters
    }
}
