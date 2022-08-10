package com.de.dhbw.ravensburg.myonlineshopdatabase.service;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.mapper.CarMapper;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Car;
import com.de.dhbw.ravensburg.myonlineshopdatabase.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarServiceImpl implements CarService{


    private CarRepository carRepository;
    private CarMapper  carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public CarDTO addCar(CarDTO carDTO) {
        Car car = carMapper.carDTOToCar(carDTO);
        return carMapper.carToCarDTO(carRepository.save(car));
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO) {
        Car tmp = this.carMapper.carDTOToCar(carDTO);
        this.carRepository.save(tmp);
        return this.carMapper.carToCarDTO(tmp);
    }

    public List<CarDTO> getAllCars() {
        return carMapper.carsToCarDTOs(carRepository.findAll());
    }

    @Override
    public CarDTO getCarById(Long id) {
        return this.carMapper.carToCarDTO(carRepository.findById(id).get());
    }

    @Override
    public void deleteCarById(long id) {
        this.carRepository.deleteById(id);
    }
}
