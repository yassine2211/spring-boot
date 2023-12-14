package com.example.projetPI.agenceDeVoyage.controllers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.print.attribute.standard.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.web.multipart.MultipartFile;

import com.example.projetPI.agenceDeVoyage.Models.destination;
import com.example.projetPI.agenceDeVoyage.services.destinationService;

@ExtendWith(MockitoExtension.class)
public class destinationControllerTest {

    @Mock
    private destinationService destinationService;

    @InjectMocks
    private destinationController destinationController;

    @BeforeEach
    public void setUp() {
        // Initialisations si nécessaire
    }
    
    @Test
    public void testGetAllDestinations() {
        when(destinationService.getAlldestinations()).thenReturn(Arrays.asList(new destination(), new destination()));
        List<destination> destinations = destinationController.getAlldestinationes();
        assertEquals(2, destinations.size());
        // Ajoutez d'autres assertions si nécessaire
    }

    @Test
    public void testGetDestinationById() {
        when(destinationService.getdestinationById(1L)).thenReturn(new destination());

        destination destination = destinationController.getdestination(1L);

        // Ajoutez des assertions appropriées
        assertEquals(1L, destination.getId());
    }

    @Test
    public void testGetDestinationByName() {
        when(destinationService.getdestinationByName("rome")).thenReturn(Arrays.asList(new destination(), new destination()));

        List<destination> destinations = destinationController.getdestinationByName("rome");

        assertEquals(2, destinations.size());
        // Ajoutez d'autres assertions si nécessaire
    }

    @Test
    public void testDeleteDestinationById() {
        destinationController.deletedestinationById(1L);

        // Ajoutez des assertions appropriées
    }

    @Test
    public void testEditDestination() throws IOException {
    	MultipartFile mockFile = new MockMultipartFile(
    	        "image",      // Nom du champ de fichier dans le formulaire
    	        "rome.jpg",  // Nom du fichier
    	        "image/jpeg", // Type MIME du fichier
    	        "Test data".getBytes() // Contenu du fichier (peut être n'importe quel tableau de bytes)
    	    );
        when(destinationService.isNomDestinationExist(anyString())).thenReturn(false);
        when(destinationService.getdestinationById(anyLong())).thenReturn(new destination());
        when(destinationService.updatedestination(any())).thenReturn(new destination());

        ResponseEntity<destination> response = destinationController.Editdestination(mockFile, "Paris", "France", 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Ajoutez d'autres assertions si nécessaire
    }

    
    @Test
    public void testAddDestination() throws IOException {
    	MultipartFile mockFile = new MockMultipartFile( 
    			"image",      // Nom du champ de fichier dans le formulaire 
    			"rome.jpg",  // Nom du fichier
    	        "image/jpeg", // Type MIME du fichier
    	        "Test data".getBytes() // Contenu du fichier (peut être n'importe quel tableau de bytes)
    	    );
        when(destinationService.isNomDestinationExist(anyString())).thenReturn(false);
        when(destinationService.addDestination(any())).thenReturn(new destination());

        ResponseEntity<destination> response = destinationController.adddestination(mockFile, "rome", "italie");

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        // Ajoutez d'autres assertions si nécessaire
    }
}
