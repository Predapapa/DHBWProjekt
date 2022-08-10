package com.de.dhbw.ravensburg.myonlineshopdatabase.controller;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class ThCarControllerImpl implements ThCarController {

    CarService carService;

    public ThCarControllerImpl(CarService carService){
        this.carService = carService;
    }

    public ModelAndView index(){
        List<CarDTO> cars = this.carService.getAllCars();

        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("data_input", cars);
        return modelAndView;
    }

}
