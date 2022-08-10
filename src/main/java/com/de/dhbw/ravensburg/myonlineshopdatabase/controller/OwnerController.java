package com.de.dhbw.ravensburg.myonlineshopdatabase.controller;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;

import java.util.List;

public interface OwnerController {
    OwnerDTO addOwner(OwnerDTO ownerDTO);
    List<OwnerDTO> getAllOwners();
    OwnerDTO getOwner(long ownerId);
    float getOwnerCarPrice(long id);
}
