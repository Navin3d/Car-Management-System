package gmc.projects.cars.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gmc.projects.cars.models.FuelType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class CarEntity implements Serializable {
	
	private static final long serialVersionUID = 8988979778608390085L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "car_id")
	private String carId;
	
	@Column(name = "car_name")
	private String carName;
	
	@Column(name = "mileage")
	private Integer mileage;
	
	@Column(name = "seating_capasity")
	private Integer seatingCapasity;
	
	@Column(name = "car_description")
	private String carDescription;
	
	@Column(name = "fuel_type")
	@Enumerated(value = EnumType.STRING)
	private FuelType fuelType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CompanyEntity company;
	
	@Lob
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "started_at")
	private Timestamp startedAt;

}
