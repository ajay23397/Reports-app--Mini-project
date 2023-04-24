package in.dxc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.dxc.Entity.CitizenPlan;

@Repository
public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

	
	@Query("select distinct (planName) from CitizenPlan")
	List<String> getCitizenPlanName();
	@Query("select distinct (planStatus) from CitizenPlan")
	List<String> getCitizenPlanStatus();
	
	
}
