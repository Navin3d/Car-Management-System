package gmc.projects.cars.services;

import gmc.projects.cars.models.CarModel;

public interface CarsService {
	CarModel findCar(String carId);
}
