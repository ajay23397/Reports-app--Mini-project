package in.dxc.Servce;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.dxc.Entity.CitizenPlan;
import in.dxc.request.SearchRequest;

public interface ReportService {
	
	List<String> getPlanName();
	List<String>getPlanstatus();
    List<CitizenPlan>search (SearchRequest request);
    public boolean exportExcel(HttpServletResponse response) throws Exception;
    public boolean exportPdf(HttpServletResponse response) throws Exception;
    
    
	

}
