package com.de.dhbw.ravensburg.myonlineshopdatabase.controller;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Car;

import java.util.List;

public interface CarController {
    List<CarDTO> getAllCars();

    CarDTO getCar(Long carId);

    void deleteCarById( Long carId);

    CarDTO addCar( CarDTO carDTO);

    CarDTO updateCar(Long movieId, CarDTO carDTO);
}
