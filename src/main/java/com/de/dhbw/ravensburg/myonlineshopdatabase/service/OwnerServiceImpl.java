package com.de.dhbw.ravensburg.myonlineshopdatabase.service;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.mapper.OwnerMapper;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Owner;
import com.de.dhbw.ravensburg.myonlineshopdatabase.repository.CarRepository;
import com.de.dhbw.ravensburg.myonlineshopdatabase.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OwnerServiceImpl implements OwnerService{

    private OwnerRepository ownerRepository;
    private CarRepository carRepository;
    private OwnerMapper ownerMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, CarRepository carRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.carRepository = carRepository;
        this.ownerMapper = ownerMapper;
    }

    public OwnerDTO addOwner(OwnerDTO ownerDTO) {
        // Die Id wird auf 0 gesetzt, falls der User eine Id eingibt
        // Wenn die Id auf 0 ist, wird die Id Auto-Generated
        ownerDTO.setId(0);
        // Speichern des Owners in das Repository
        Owner owner = ownerMapper.ownerDTOToOwner(ownerDTO);
        return ownerMapper.ownerToOwnerDTO(ownerRepository.save(owner));
    }

    public List<OwnerDTO> getAllOwners() {
        return ownerMapper.ownersToOwnerDTOs(ownerRepository.findAll());
    }


    public OwnerDTO getOwnerById(Long ownerId){return null;}


    @Override
    public float getOwnerCarPrice(Long ownerId) {
        // Abfrage aller Preise eines Owners
        List<Float> carPrices = carRepository.findAllByOwner(ownerRepository.findById(ownerId).get()).stream().map(p -> p.getPrice()).collect(Collectors.toList()); ;
        float sum =0;
        for (int i = 0; i < carPrices.size(); i++){
            sum += carPrices.get(i);
        }
        if (sum == 0 ){
            return 0f;
        }
        // Rückgabe des Durchschnittwertes
        return  sum/carPrices.size();
    }
}
