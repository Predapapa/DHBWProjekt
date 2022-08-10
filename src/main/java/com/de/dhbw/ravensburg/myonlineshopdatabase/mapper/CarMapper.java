package com.de.dhbw.ravensburg.myonlineshopdatabase.mapper;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Car;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTO carToCarDTO(Car car);
    List<CarDTO> carsToCarDTOs(List<Car> cars);

    @InheritInverseConfiguration
    Car carDTOToCar(CarDTO carDTO);
    List<Car> carDTOsToCars(List<CarDTO> carDTOList);
}
