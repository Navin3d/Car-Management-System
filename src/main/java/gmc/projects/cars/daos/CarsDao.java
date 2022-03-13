package gmc.projects.cars.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.projects.cars.entities.CarEntity;

public interface CarsDao extends JpaRepository<CarEntity, Long> {
	CarEntity findByCarId(String carId);
}
