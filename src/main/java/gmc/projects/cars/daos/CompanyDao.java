package gmc.projects.cars.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.projects.cars.entities.CompanyEntity;

public interface CompanyDao extends JpaRepository<CompanyEntity, Long> {
	CompanyEntity findByCompanyId(String companyId);
}
