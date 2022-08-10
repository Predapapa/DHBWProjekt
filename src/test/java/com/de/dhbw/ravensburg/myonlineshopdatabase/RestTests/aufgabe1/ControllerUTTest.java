package com.de.dhbw.ravensburg.myonlineshopdatabase.RestTests.aufgabe1;

import com.de.dhbw.ravensburg.myonlineshopdatabase.controller.OwnerControllerImpl;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Owner;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.OwnerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerUTTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private OwnerDTO ownerDTO;


    @BeforeEach
    public void setup() {
        ownerDTO = new OwnerDTO("Hans Peter", "88214 Ravensburg, Germany");
        ownerDTO.setId(1l);
    }

    /**
     * Testet, ob die Methode als RestController agiert (@GetMapping)
     * @throws Exception
     */
    @Test
    public void getOwnerfromURL() throws Exception {

        //act
        ResponseEntity<OwnerDTO> response = restTemplate.getForEntity("/api/v1/owners/1", OwnerDTO.class);
        //System.out.println(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ownerDTO.getName(), response.getBody().getName());
        assertEquals(ownerDTO.getAddress(), response.getBody().getAddress());

    }

    /**
     * Idee für nicht berarbeiten
     */
    //Stoppen
    //icacls testpermission.java /inheritance:r
    //Zurücksetzen
   // icacls testpermission.java /inheritance:e
}
