package gmc.projects.cars.services;

import java.util.List;

import gmc.projects.cars.models.CarModel;
import gmc.projects.cars.models.CompanyModel;

public interface CompanyServices {
	List<CompanyModel> findAllCompanies();
	List<CarModel> findAllCompanyCars(String companyId);
	CompanyModel save(CompanyModel companyModel);
	void deleteACompany(String companyId);
}
