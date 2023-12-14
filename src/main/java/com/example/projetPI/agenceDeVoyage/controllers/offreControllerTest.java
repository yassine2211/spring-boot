package com.example.projetPI.agenceDeVoyage.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import com.example.projetPI.agenceDeVoyage.Models.offre;
import com.example.projetPI.agenceDeVoyage.services.destinationService;
import com.example.projetPI.agenceDeVoyage.services.offreService;

@ExtendWith(MockitoExtension.class)
public class offreControllerTest {

    @Mock
    private offreService offreService;

    @Mock
    private destinationService destinationService;

    @InjectMocks
    private offreController offreController;

    @BeforeEach
    public void setUp() {
        // Initialization if necessary
    }

    @Test
    public void testGetAlloffres() {
        // Mocking the service to return a list of two offers
        when(offreService.getAlloffres()).thenReturn(Arrays.asList(new offre(), new offre()));

        // Calling the controller method
        List<offre> offres = offreController.getAlloffrees();

        // Assertions
        assertEquals(2, offres.size(), "The number of offers should be 2");
        assertTrue(offres.stream().allMatch(offer -> offer instanceof offre),
                "All elements in the list should be of type offre");
    }

    @Test
    public void testGetoffreById() {
        // Mocking the service to return an offer with ID 1
        when(offreService.getoffreById(1L)).thenReturn(new offre());

        // Calling the controller method
        offre offre = offreController.getoffre(1L);

        // Assertions
        assertNotNull(offre, "The returned offer should not be null");
        assertEquals(1L, offre.getId(), "The offer ID should be 1");
    }

    @Test
    public void testGetoffreByName() {
        // Mocking the service to return a list of two offers
        when(offreService.getoffreByName("TestName")).thenReturn(Arrays.asList(new offre(), new offre()));

        // Calling the controller method
        List<offre> offres = offreController.getoffreByName("TestName");

        // Assertions
        assertEquals(2, offres.size(), "The number of offers should be 2");
        assertTrue(offres.stream().allMatch(offer -> offer instanceof offre),
                "All elements in the list should be of type offre");
    }

    @Test
    public void testDeleteoffreById() {
        // Calling the controller method
        offreController.deleteoffreById(1L);

        // No specific assertions for deletion; if no exception is thrown, consider it successful
    }

    @Test
    public void testEditoffre() throws IOException {
        // Mocking a MultipartFile
        MockMultipartFile mockFile = new MockMultipartFile("img", "test.jpg", "image/jpeg", "Test data".getBytes());

        // Mocking the service to return an existing offer
        when(offreService.getoffreById(anyLong())).thenReturn(new offre());

        // Mocking the service to return an updated offer
        when(offreService.updateoffre(any(offre.class))).thenReturn(new offre());

        // Calling the controller method
        ResponseEntity<offre> response = offreController.Editoffre(mockFile, "TestName", "7 days", 1L,
                "TestDescription", Date.valueOf("2023-01-01"), 100.0f, 1L);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode(), "HTTP status should be OK");
        assertNotNull(response.getBody(), "The returned offer should not be null");
        assertEquals("TestName", response.getBody().getName(), "The offer name should be 'TestName'");
    }

    @Test
    public void testAddoffre() throws IOException {
        // Mocking a MultipartFile
        MockMultipartFile mockFile = new MockMultipartFile("img", "test.jpg", "image/jpeg", "Test data".getBytes());

        // Creating a new offer to be returned by the mock service with a valid ID
        offre mockAddedOffer = new offre();
        mockAddedOffer.setId(1L);

        // Mocking the service to return the newly added offer
        when(offreService.addoffre(any(offre.class))).thenReturn(mockAddedOffer);

        // Calling the controller method
        ResponseEntity<offre> response = offreController.addoffre(mockFile, "TestName", "7 days", "TestDescription",
                Date.valueOf("2023-01-01"), 100.0f, 1L);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "HTTP status should be CREATED");
        assertNotNull(response.getBody(), "The returned offer should not be null");
        assertEquals("TestName", response.getBody().getName(), "The offer name should be 'TestName'");
        assertEquals(1L, response.getBody().getId(), "The offer ID should be 1");
    }
}
