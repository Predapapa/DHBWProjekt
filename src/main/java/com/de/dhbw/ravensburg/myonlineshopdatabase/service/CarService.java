package com.de.dhbw.ravensburg.myonlineshopdatabase.service;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();
    CarDTO getCarById(Long id);
    void deleteCarById(long id);
    CarDTO addCar(CarDTO carDTO);
    CarDTO updateCar(CarDTO carDTO);
}
