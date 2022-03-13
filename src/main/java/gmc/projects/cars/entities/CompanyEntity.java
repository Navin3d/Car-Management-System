package gmc.projects.cars.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gmc.projects.cars.models.FuelType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class CompanyEntity implements Serializable {
	
	private static final long serialVersionUID = 2029900306686802965L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "company_id")
	private String companyId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_description")
	private String companyDescription;
	
	@OneToMany(mappedBy = "company")
	private Set<CarEntity> cars;
	
	@Lob
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "started_at")
	private Timestamp startedAt;
	
	public CompanyEntity() {
		this.cars = new HashSet<>();
	}

}
