package gmc.projects.cars.models;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class CompanyModel implements Serializable {

	private static final long serialVersionUID = -3108420650683025705L;
	
	private String companyId;
	
	private String companyName;
	
	private String companyDescription;
	
	private String imageUrl;
	
	private Timestamp startedAt;

}
