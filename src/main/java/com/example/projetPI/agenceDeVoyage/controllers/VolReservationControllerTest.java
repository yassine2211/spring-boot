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
import com.example.projetPI.agenceDeVoyage.Models.vol;
import com.example.projetPI.agenceDeVoyage.Models.volReservation;
import com.example.projetPI.agenceDeVoyage.services.volReservationService;
import com.example.projetPI.agenceDeVoyage.services.volService;

@ExtendWith(MockitoExtension.class)
public class VolReservationControllerTest {

    @Mock
    private volReservationService volReservationService;

    @Mock
    private volService volService;

    @InjectMocks
    private volReservationController volReservationController;

    @BeforeEach
    public void setUp() {
        // Initialization if necessary
    }

    @Test
    public void testGetAllVolReservations() {
        when(volReservationService.getAllvolReservations()).thenReturn(Arrays.asList(new volReservation(), new volReservation()));
        List<volReservation> volReservations = volReservationController.getAllvolReservationes();
        assertEquals(2, volReservations.size());
        // Add other assertions if necessary
    }

    @Test
    public void testGetVolReservationById() {
        when(volReservationService.getvolReservationById(5L)).thenReturn(new volReservation());
        volReservation volRes = volReservationController.getvolReservation(5L);
        // Add appropriate assertions
        assertEquals(5L, volRes.getId());
    }

    @Test
    public void testDeleteVolReservationById() {
        volReservationController.deletevolReservationById(1L);
        // Add appropriate assertions
    }

    @Test
    public void testAddVolReservation() {
        // Create an instance of volReservation with desired parameters
        volReservation volResToAdd = new volReservation();
        volResToAdd.setId(4L);

        // Mocking the behavior of volService to return a dummy vol
        when(volService.getvolById(anyLong())).thenReturn(new vol());

        // Configure the service behavior for the test
        when(volReservationService.addvolReservation(any())).thenReturn(volResToAdd);

        // Call the method to test with the parameters
        volReservation addedVolRes = volReservationController.addvolReservation(volResToAdd, 1L); // Assuming 1L is the volId

        // Add appropriate assertions
        assertEquals(4L, addedVolRes.getId());
        // Add other assertions for other added parameters
    }

    @Test
    public void testEditVolReservation() {
        // Create an instance of volReservation with desired parameters
        volReservation volResToUpdate = new volReservation();
        volResToUpdate.setId(1L);

        // Configure the service behavior for the test
        when(volReservationService.updatevolReservation(any())).thenReturn(volResToUpdate);

        // Call the method to test with the parameters
        volReservation editedVolRes = volReservationController.EditvolReservation(volResToUpdate);

        // Add appropriate assertions
        assertEquals(1L, editedVolRes.getId());
        // Add other assertions for other updated parameters
    }
}
