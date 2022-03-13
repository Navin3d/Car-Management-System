package gmc.projects.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gmc.projects.cars.models.CompanyModel;
import gmc.projects.cars.services.CompanyServices;

@Controller
@RequestMapping(path = "/company")
public class CompanyController {
	
	@Autowired
	private CompanyServices companyServices;
	
	@GetMapping
	private String getAllCompanies(Model model) {
		model.addAttribute("companies", companyServices.findAllCompanies());
		return "companies";
	}
	
	@GetMapping("/{companyId}/cars")
	private String getAllCompanies(@PathVariable String companyId, Model model) {
		model.addAttribute("cars", companyServices.findAllCompanyCars(companyId));
		return "cars";
	}
	
	@GetMapping("/{companyId}/delete")
	private String deleteACompany(@PathVariable String companyId) {
		companyServices.deleteACompany(companyId);
		return "redirect:/company";
	}
	
	@PostMapping
	private String createOrUpdate(@ModelAttribute("company") CompanyModel companyModel) {
		companyServices.save(companyModel);
		return "redirect:/company";
	}

}
