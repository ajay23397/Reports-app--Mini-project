package in.dxc.Runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.dxc.Entity.CitizenPlan;
import in.dxc.Repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		
		repo.deleteAll();
		CitizenPlan c1= new CitizenPlan();
		 
		c1.setCitizenName("john");
		c1.setGender("Male");
		c1.setPlanName("cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmt(5000.00);
		
		CitizenPlan c2= new CitizenPlan();
		c2.setCitizenName("Gian");
		c2.setGender("Male");
		c2.setPlanName("cash");
		c2.setPlanStatus("Denied");
	     c2.setDenialReason("Rental amount");
		
	     
	     CitizenPlan c3= new CitizenPlan();
		c3.setCitizenName("justin");
		c3.setGender("Male");
		c3.setPlanName("cash");
		c3.setPlanStatus("terminated");
		c3.setPlanStartDate(LocalDate.now());
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmt(5000.00);
		c3.setTerminateddate(LocalDate.now());
		c3.setTerminationRsn("Employee");
		
		
		CitizenPlan c4= new CitizenPlan();
		c4.setCitizenName("Cath");
		c4.setGender("Female");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmt(5000.00);
		
		CitizenPlan c5= new CitizenPlan();
		c5.setCitizenName("emman");
		c5.setGender("male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
	    c5.setDenialReason("salaried person");
	    
	    CitizenPlan c6= new CitizenPlan();
		c6.setCitizenName("buttler");
		c6.setGender("Male");
		c6.setPlanName("Food");
		c6.setPlanStatus("terminated");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmt(5000.00);
		c6.setTerminateddate(LocalDate.now());
		c6.setTerminationRsn(" goverment Employee");
		
		
	   
		CitizenPlan c7= new CitizenPlan();
		 c7.setCitizenName("Ajay");
		c7.setGender("Male");
		c7.setPlanName("Travell");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmt(5000.00);
		
		CitizenPlan c8= new CitizenPlan();
		c8.setCitizenName("Rohit");
		c8.setGender("male");
		c8.setPlanName("Travell");
		c8.setPlanStatus("Denied");
	    c8.setDenialReason("student");
	     
		
		CitizenPlan c9= new CitizenPlan();
		c9.setCitizenName("rishi");
		c9.setGender("Male");
		c9.setPlanName("travell");
		c9.setPlanStatus("terminated");
		c9.setPlanStartDate(LocalDate.now());
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitAmt(5000.00);
		c9.setTerminateddate(LocalDate.now());
		c9.setTerminationRsn("income tax issue");
		
		
		CitizenPlan c10= new CitizenPlan();
		 
		c10.setCitizenName("ashok");
		c10 .setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifitAmt(5000.00);
		
	    CitizenPlan c11= new CitizenPlan();
		c11.setCitizenName("devid");
		c11.setGender("male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
	    c11.setDenialReason(" own business");
	     
		
		CitizenPlan c12= new CitizenPlan();
		c12.setCitizenName("jamie");
		c12.setGender("Female");
		c12.setPlanName("Employment");
		c12.setPlanStatus("terminated");
		c12.setPlanStartDate(LocalDate.now());
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenifitAmt(5000.00);
		c12.setTerminateddate(LocalDate.now());
		c12.setTerminationRsn("Student");
		
		List<CitizenPlan> plan=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		repo.saveAll(plan);
		
	}

}
