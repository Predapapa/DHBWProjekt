package com.de.dhbw.ravensburg.myonlineshopdatabase.controller;

import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.CarDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ThCarController {
    @GetMapping(value = {"/", "index"})
    ModelAndView index();


}
