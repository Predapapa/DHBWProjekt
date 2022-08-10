package com.de.dhbw.ravensburg.myonlineshopdatabase.controller;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/cars")
public class CarControllerImpl implements CarController {

    CarService carService;

    public CarControllerImpl(CarService carService){
        this.carService = carService;
    }


    @GetMapping
    public List<CarDTO> getAllCars(){
        return this.carService.getAllCars();
    }

    @GetMapping("/{carId}")
    public CarDTO getCar(@PathVariable("carId") Long carId){
        return this.carService.getCarById(carId);
    }

    @DeleteMapping("/{carId}")
    public void deleteCarById(@PathVariable("carId") Long carId){
            this.carService.deleteCarById(carId);
    }

    @PostMapping
    public CarDTO addCar(@RequestBody CarDTO carDTO){
            return this.carService.addCar(carDTO);
    }

    @PutMapping("/{carId}")
    public CarDTO updateCar(@PathVariable("carId") Long carId, @RequestBody CarDTO carDTO){
        carDTO.setId(carId);
        return this.carService.updateCar(carDTO);
    }

}
