package in.dxc.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Citizen_Plans_Info")
public class CitizenPlan {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer  citizenId;
	private String citizenName;
	private String gender;
	private String  planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benifitAmt;
	private String denialReason;
	private LocalDate terminateddate;
	private String terminationRsn;
	public Integer getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public LocalDate getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}
	public LocalDate getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}
	public Double getBenifitAmt() {
		return benifitAmt;
	}
	public void setBenifitAmt(Double benifitAmt) {
		this.benifitAmt = benifitAmt;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	public LocalDate getTerminateddate() {
		return terminateddate;
	}
	public void setTerminateddate(LocalDate terminateddate) {
		this.terminateddate = terminateddate;
	}
	public String getTerminationRsn() {
		return terminationRsn;
	}
	public void setTerminationRsn(String terminationRsn) {
		this.terminationRsn = terminationRsn;
	}
	
	
	
	

}
