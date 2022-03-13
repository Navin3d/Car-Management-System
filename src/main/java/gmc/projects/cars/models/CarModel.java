package gmc.projects.cars.models;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class CarModel implements Serializable {

	private static final long serialVersionUID = 3978638996313862733L;
	
	private String carId;
	
	private String carName;
	
	private Integer mileage;
	
	private Integer seatingCapasity;
	
	private String carDescription;

	private FuelType fuelType;

	private String imageUrl;
	
	private Timestamp startedAt;

}
