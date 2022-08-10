package com.de.dhbw.ravensburg.myonlineshopdatabase.Restcontroller;

import com.de.dhbw.ravensburg.myonlineshopdatabase.controller.OwnerController;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = OwnerController.class)
public class OwnerRestControllerUTTest {

    @Autowired
    private OwnerController ownerController;

    @MockBean
    private OwnerService ownerService;

    private OwnerDTO ownerDTO;

    @BeforeEach
    public void setUp() {
        //Erstellung des Owners
        this.ownerDTO = new OwnerDTO( "Hamid", "London");
        this.ownerDTO.setId(1);
    }


    @Test
    public void shouldSuccessfullyGetOwnerCarPrice() {
        when(ownerService.getOwnerCarPrice(1l)).thenReturn(50000f);
        float result = this.ownerController.getOwnerCarPrice(2);
        verify(ownerService).getOwnerById(2l);
        assert(result<0);
    }






}
