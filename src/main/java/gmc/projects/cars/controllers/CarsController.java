package gmc.projects.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import gmc.projects.cars.services.CarsService;

@Controller
@RequestMapping(path = "/car")
public class CarsController {
	
	@Autowired
	private CarsService carsService;
	
	@GetMapping("/{carId}/show")
	private String getCarDetail(@PathVariable String carId, Model model) {
		model.addAttribute("car", carsService.findCar(carId));
		return "cardetail";
	}

}
