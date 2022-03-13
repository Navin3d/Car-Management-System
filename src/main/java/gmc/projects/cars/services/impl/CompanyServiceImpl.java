package gmc.projects.cars.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.projects.cars.daos.CompanyDao;
import gmc.projects.cars.entities.CompanyEntity;
import gmc.projects.cars.models.CarModel;
import gmc.projects.cars.models.CompanyModel;
import gmc.projects.cars.services.CompanyServices;

@Service
public class CompanyServiceImpl implements CompanyServices {
	
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<CompanyModel> findAllCompanies() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		List<CompanyModel> returnValue = new ArrayList<>();
		
		List<CompanyEntity> allCompanies = companyDao.findAll();
		
		allCompanies.iterator().forEachRemaining(company -> {
			returnValue.add(modelMapper.map(company, CompanyModel.class)); 
		});
		
		return returnValue;
	}

	@Override
	public List<CarModel> findAllCompanyCars(String companyId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		List<CarModel> returnValue = new ArrayList<>();
		
		CompanyEntity foundCompany = companyDao.findByCompanyId(companyId);
		
		foundCompany.getCars().iterator()
			.forEachRemaining(car -> {
			 	returnValue.add(modelMapper.map(car, CarModel.class));
			});
		
		return returnValue;
	}

	@Override
	public CompanyModel save(CompanyModel companyModel) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		CompanyEntity detachedEntity = new CompanyEntity();
		
		if(companyModel.getCompanyId() == null) {
			modelMapper.map(companyModel, detachedEntity);
			detachedEntity.setCompanyId(UUID.randomUUID().toString());
		} else 
			modelMapper.map(companyModel, detachedEntity);
		
		CompanyModel returnValue = modelMapper.map(companyDao.save(detachedEntity), CompanyModel.class);
		
		return returnValue;
	}

	@Override
	public void deleteACompany(String companyId) {
		CompanyEntity foundCompany = companyDao.findByCompanyId(companyId);		
		companyDao.delete(foundCompany);
	}

}
