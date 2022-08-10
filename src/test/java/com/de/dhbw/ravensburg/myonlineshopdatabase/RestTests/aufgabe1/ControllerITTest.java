package com.de.dhbw.ravensburg.myonlineshopdatabase.RestTests.aufgabe1;

import com.de.dhbw.ravensburg.myonlineshopdatabase.controller.OwnerControllerImpl;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.OwnerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ControllerITTest {

    /**
     * Testet, ob der Service aufgerufen wird ohne @GetMapping
     *
     * @throws Exception
     */
    @Test
    public void getOwnerwithServiceAndNoRest() throws Exception {
        OwnerDTO owner = new OwnerDTO("Hans Peter", "88214 Ravensburg, Germany");
        owner.setId(1l);

        OwnerService ownerService = Mockito.mock(OwnerService.class);
        when(ownerService.getOwnerById(1l)).thenReturn(owner);
        OwnerControllerImpl ownerController = new OwnerControllerImpl(ownerService);
        OwnerDTO result = ownerController.getOwner(1l);

        verify(ownerService, times(1)).getOwnerById(1l);

        assertEquals(1, result.getId());
        assertEquals("Hans Peter", result.getName());
        assertEquals("88214 Ravensburg, Germany", result.getAddress());

    }


    /**
     * Testet, ob HTTP_NOT_Found geworfen wird ohne @GetMapping
     *
     * @throws Exception
     */
    @Test
    public void shouldFailGetOwnerWhenCalledWithNotExistingIdAndNoRest() throws Exception {
        OwnerDTO owner = new OwnerDTO("Hans Peter", "88214 Ravensburg, Germany");
        owner.setId(2l);

        OwnerService ownerService = Mockito.mock(OwnerService.class);
        when(ownerService.getOwnerById(any())).thenThrow(NoSuchElementException.class);

        OwnerControllerImpl ownerController = new OwnerControllerImpl(ownerService);
        ResponseStatusException ex = Assert.assertThrows(ResponseStatusException.class, () -> ownerController.getOwner(2l));

        assertEquals(404, ex.getRawStatusCode());

        verify(ownerService, times(1)).getOwnerById(2l);
    }

}
