package gmc.projects.cars.bootstraps;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import gmc.projects.cars.daos.CarsDao;
import gmc.projects.cars.daos.CompanyDao;
import gmc.projects.cars.entities.CarEntity;
import gmc.projects.cars.entities.CompanyEntity;
import gmc.projects.cars.models.FuelType;

@Component
public class CompanyBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private CarsDao carsDao;

	public List<CompanyEntity> getInitialDatas() {
		List<CompanyEntity> returnValue = new ArrayList<>();

		CarEntity car1 = new CarEntity();
		car1.setCarId("CAR-" + UUID.randomUUID());
		car1.setCarName("Tesla Model S");
		car1.setCarDescription("This is my favorite EV.");
		car1.setFuelType(FuelType.Electric);
		car1.setMileage(512);
		car1.setSeatingCapasity(5);
		car1.setStartedAt(new Timestamp(2012, 7, 1, 0, 0, 0, 0));
		car1.setImageUrl("https://images.unsplash.com/photo-1617704548623-340376564e68?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dGVzbGElMjBjYXJ8ZW58MHx8MHx8&w=1000&q=80");		
				
		CompanyEntity company1 = new CompanyEntity();
		Set<CarEntity> cars = new HashSet<>();		

		company1.setCompanyId("CMP-" + UUID.randomUUID());
		company1.setCompanyName("Tesla");
		company1.setCompanyDescription("An American electric vehicle and clean energy company based in Austin.");
		company1.setImageUrl("https://wallpaperaccess.com/full/344404.jpg");
		company1.setStartedAt(new Timestamp(2003, 7, 1, 0, 0, 0, 0));
		
		cars.add(car1);
		car1.setCompany(company1);
		company1.setCars(cars);
		carsDao.save(car1);

		returnValue.add(company1);
		
		CompanyEntity company2 = new CompanyEntity();
		company2.setCompanyId("CMP-" + UUID.randomUUID());
		company2.setCompanyName("Jaguar");
		company2.setCompanyDescription("Jaguar is the luxury vehicle brand of Jaguar Land Rover.");
		company2.setImageUrl("https://upload.wikimedia.org/wikipedia/en/b/b4/Jaguar_2012_logo.png");
		company2.setStartedAt(new Timestamp(1922, 9, 4, 0, 0, 0, 0));
		returnValue.add(company2);
		
		CompanyEntity company3 = new CompanyEntity();
		company3.setCompanyId("CMP-" + UUID.randomUUID());
		company3.setCompanyName("Audi");
		company3.setCompanyDescription("Audi AG is a German automotive manufacturer of luxury vehicles headquartered in Ingolstadt.");
		company3.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWIpcVM-8mD9OhrL1jlAcgsLKTLv_3ji8I5A&usqp=CAU");
		company3.setStartedAt(new Timestamp(1909, 7, 16, 0, 0, 0, 0));
		returnValue.add(company3);
		
		CompanyEntity company4 = new CompanyEntity();
		company4.setCompanyId("CMP-" + UUID.randomUUID());
		company4.setCompanyName("Mercedes-Benz");
		company4.setCompanyDescription("Mercedes-Benz, commonly referred to as just Mercedes.");
		company4.setImageUrl("data:image/jpeg;base64,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");
		company4.setStartedAt(new Timestamp(1926, 6, 28, 0, 0, 0, 0));
		returnValue.add(company4);
		
		CompanyEntity company5 = new CompanyEntity();
		company5.setCompanyId("CMP-" + UUID.randomUUID());
		company5.setCompanyName("Nissan");
		company5.setCompanyDescription("Nissan Motor Co., Ltd. is a Japanese multinational automobile manufacturer headquartered in Nishi-ku.");
		company5.setImageUrl("data:image/jpeg;base64,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");
		company5.setStartedAt(new Timestamp(1933, 5, 26, 0, 0, 0, 0));
		returnValue.add(company5);
		
		CompanyEntity company6 = new CompanyEntity();
		company6.setCompanyId("CMP-" + UUID.randomUUID());
		company6.setCompanyName("Rolls-Royce");
		company6.setCompanyDescription("Rolls-Royce Motor Cars Limited is a British luxury automobile maker.");
		company6.setImageUrl("data:image/jpeg;base64,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");
		company6.setStartedAt(new Timestamp(1904, 7, 1, 0, 0, 0, 0));
		returnValue.add(company6);
		
		CompanyEntity company7 = new CompanyEntity();
		company7.setCompanyId("CMP-" + UUID.randomUUID());
		company7.setCompanyName("Mazda");
		company7.setCompanyDescription("Mazda Motor Corporation is a Japanese multinational automaker based in Fuchū, Hiroshima, Japan.");
		company7.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsDfQGmQA4h1nbfaKW2PMShQ8ZIPZBcATIVA&usqp=CAU");
		company7.setStartedAt(new Timestamp(2003, 7, 1, 0, 0, 0, 0));
		returnValue.add(company7);
		
		CompanyEntity company8 = new CompanyEntity();
		company8.setCompanyId("CMP-" + UUID.randomUUID());
		company8.setCompanyName("Mitsubishi");
		company8.setCompanyDescription("Mitsubishi Motors Corporation is a Japanese multinational automobile manufacturer headquartered in Minato, Tokyo.");
		company8.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9soUU-CrD1Lxh0d7z-Fbxxcc8f3r-I5PaAQchfF6N7HzI75Eqy972RgpMYE4b1bZej3Q&usqp=CAU");
		company8.setStartedAt(new Timestamp(1970, 7, 1, 0, 0, 0, 0));
		returnValue.add(company8);
		
		CompanyEntity company9 = new CompanyEntity();
		company9.setCompanyId("CMP-" + UUID.randomUUID());
		company9.setCompanyName("BMW");
		company9.setCompanyDescription("Bayerische Motoren Werke AG, commonly referred to as BMW.");
		company9.setImageUrl("data:image/jpeg;base64,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");
		company9.setStartedAt(new Timestamp(1916, 3, 7, 0, 0, 0, 0));
		returnValue.add(company9);
		
		return returnValue;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		companyDao.saveAll(getInitialDatas());
	}

}