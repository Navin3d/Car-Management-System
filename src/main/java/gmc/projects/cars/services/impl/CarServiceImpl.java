package gmc.projects.cars.services.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.projects.cars.daos.CarsDao;
import gmc.projects.cars.models.CarModel;
import gmc.projects.cars.services.CarsService;

@Service
public class CarServiceImpl implements CarsService {
	
	@Autowired
	private CarsDao carsDao;

	@Override
	public CarModel findCar(String carId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		CarModel returnValue = modelMapper.map(carsDao.findByCarId(carId), CarModel.class);
		
		return returnValue;
	}

}
