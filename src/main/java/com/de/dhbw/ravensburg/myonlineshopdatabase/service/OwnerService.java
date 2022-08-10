package com.de.dhbw.ravensburg.myonlineshopdatabase.service;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
    OwnerDTO addOwner(OwnerDTO ownerDTO);
    List<OwnerDTO> getAllOwners();
    OwnerDTO getOwnerById(Long ownerId);
    float getOwnerCarPrice(Long ownerId);

}
