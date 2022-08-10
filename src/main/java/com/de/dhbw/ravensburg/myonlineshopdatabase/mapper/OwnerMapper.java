package com.de.dhbw.ravensburg.myonlineshopdatabase.mapper;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Owner;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerDTO ownerToOwnerDTO(Owner owner);
    List<OwnerDTO> ownersToOwnerDTOs(List<Owner> owners);

    @InheritInverseConfiguration
    Owner ownerDTOToOwner(OwnerDTO ownerDTO);
    List<Owner> ownerDTOsToOwners(List<OwnerDTO> ownerDTOList);
}
