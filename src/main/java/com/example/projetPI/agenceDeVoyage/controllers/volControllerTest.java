package com.example.projetPI.agenceDeVoyage.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
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
import com.example.projetPI.agenceDeVoyage.Models.vol;
import com.example.projetPI.agenceDeVoyage.services.volService;

@ExtendWith(MockitoExtension.class)
public class volControllerTest {

    @Mock
    private volService volService;

    @InjectMocks
    private volController volController;

    @BeforeEach
    public void setUp() {
        // Initialisations si nécessaire
    }

    @Test
    public void testGetAllVols() {
        when(volService.getAllvols()).thenReturn(Arrays.asList(new vol(), new vol()));
        List<vol> vols = volController.getAllvoles();
        assertEquals(2, vols.size());
        // Ajoutez d'autres assertions si nécessaire
    }

    @Test
    public void testGetVolById() {
        when(volService.getvolById(5L)).thenReturn(new vol());
        vol vol = volController.getvol(5L);
        // Ajoutez des assertions appropriées
        assertEquals(5L, vol.getId());
    }

    @Test
    public void testGetVolByName() {
        when(volService.getvolByName("Paris")).thenReturn(Arrays.asList(new vol(), new vol()));
        List<vol> vols = volController.getvolByName("Paris");
        assertEquals(2, vols.size());
        // Ajoutez d'autres assertions si nécessaire
    }

    @Test
    public void testDeleteVolById() {
        volController.deletevolById(1L);

        // Ajoutez des assertions appropriées
    }

    
    @Test
    public void testEditVol() {
        // Créez une instance de vol avec les paramètres souhaités
        vol volToUpdate = new vol();
        volToUpdate.setId(1L);
        volToUpdate.setDepart("Paris");
        volToUpdate.setName("New York");
        volToUpdate.setClasse("affaires");
        volToUpdate.setPrix(1500.0f);
        volToUpdate.setDateDep(Date.valueOf("2023-01-01"));
        // Ajoutez d'autres paramètres à mettre à jour

        // Configurez le comportement du service pour le test
        when(volService.updatevol(any())).thenReturn(volToUpdate);

        // Appelez la méthode à tester avec les paramètres
        vol editedVol = volController.Editvol(volToUpdate);

        // Ajoutez des assertions appropriées
        assertEquals(1L, editedVol.getId());
        assertEquals("Paris", editedVol.getDepart());
        assertEquals("New York", editedVol.getName());
        assertEquals("affaires", editedVol.getClasse());
        assertEquals(1500.0f, editedVol.getPrix(), 0.01); // Utilisez une tolérance pour les valeurs flottantes
        assertEquals(Date.valueOf("2023-01-01"), editedVol.getDateDep());
        // Ajoutez d'autres assertions pour les autres paramètres mis à jour
    }

    @Test
    public void testAddVol() {
        // Créez une instance de vol avec les paramètres souhaités
        vol volToAdd = new vol();
        volToAdd.setId(4L);
        volToAdd.setDepart("paris");
        volToAdd.setName("tunis");
        volToAdd.setClasse("economique");
        volToAdd.setPrix(1000.0f);
        volToAdd.setDateDep(Date.valueOf("2023-02-01"));
        // Ajoutez des valeurs pour les autres paramètres

        // Configurez le comportement du service pour le test
        when(volService.addvol(any())).thenReturn(volToAdd);

        // Appelez la méthode à tester avec les paramètres
        vol addedVol = volController.addvol(volToAdd);

        // Ajoutez des assertions appropriées
        assertEquals(4L, addedVol.getId());
        assertEquals("paris", addedVol.getDepart());
        assertEquals("tunis", addedVol.getName());
        assertEquals("economique", addedVol.getClasse());
        assertEquals(1000.0f, addedVol.getPrix(), 0.01); // Utilisez une tolérance pour les valeurs flottantes
        assertEquals(Date.valueOf("2023-02-01"), addedVol.getDateDep());
        // Ajoutez d'autres assertions pour les autres paramètres ajoutés
    }
}
