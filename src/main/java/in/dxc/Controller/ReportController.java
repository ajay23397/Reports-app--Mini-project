package in.dxc.Controller;



import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.dxc.Entity.CitizenPlan;
import in.dxc.Servce.ReportService;
import in.dxc.request.SearchRequest;

@Controller
public class ReportController {

	
	@Autowired
	private ReportService service;
	@GetMapping("/pdf")
	public void pdfExport (HttpServletResponse response) throws Exception{
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");//in which format content will come
		service.exportPdf(response);
	}
	
	@GetMapping("/excel")
public void excelExport (HttpServletResponse response) throws Exception{
	
	response.setContentType("application/octet-stream");
	response.addHeader("Content-Disposition", "attachment;filename=plans.xls");//in which format content will come
	service.exportExcel(response);
}
	
	@PostMapping("/search")
	public String handleSearch(SearchRequest search, Model model)
	{
		
		  List<CitizenPlan> plans =service.search(search);
		  model.addAttribute("plans", plans);
		//  model.addAttribute("search", search);// whatever the form data i am getting same object i am sending back to the UI
		   init(model);
		return "index";
	}
	
	
	@GetMapping("/")
	public String indexPage(Model model)
	{
		
	/* model is used to send the data from controller to UI
	 * here we are creating search request object and sending search request object to the UI by using model
	 * 
	 * index page method is used to load empty page
	 */
		SearchRequest searchObj= new SearchRequest();
		model.addAttribute("search",searchObj);
		init(model);//init method is responsibal to send plan name andd plan status to UI
		
		return "index";
	}


	private void init(Model model) {
		/*
		 * here we set Empty object 
		 */
		//SearchRequest searchObj= new SearchRequest();
		//model.addAttribute("search",searchObj);
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanstatus());
	}
	
	
	
}
