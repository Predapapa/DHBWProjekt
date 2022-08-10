package com.de.dhbw.ravensburg.myonlineshopdatabase.controller;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerControllerImpl implements OwnerController {

    private OwnerService ownerService;

    public OwnerControllerImpl(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public OwnerDTO addOwner(@RequestBody OwnerDTO ownerDTO) {
        return this.ownerService.addOwner(ownerDTO);
    }

    @GetMapping
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/price/{ownerId}")
    public float getOwnerCarPrice(@PathVariable(name = "ownerId") long ownerId) {
        return ownerService.getOwnerCarPrice(ownerId);
    }

    public OwnerDTO getOwner(long ownerId) {return null;}
}
