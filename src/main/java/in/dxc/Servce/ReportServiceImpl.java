package in.dxc.Servce;


import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.dxc.Entity.CitizenPlan;
import in.dxc.Repository.CitizenPlanRepository;
import in.dxc.Util.EmailUtils;
import in.dxc.Util.ExcelGenerator;
import in.dxc.Util.PdfGenerator;
import in.dxc.request.SearchRequest;
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository repo;
	@Autowired
	EmailUtils emailUtils;
    @Autowired
	ExcelGenerator generator;
    @Autowired
    PdfGenerator genpdf;
	@Override
	public List<String> getPlanName() {
		// TODO Auto-generated method stub
		return repo.getCitizenPlanName();
	}

	@Override
	public List<String> getPlanstatus() {
	
		return repo.getCitizenPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		CitizenPlan entity = new CitizenPlan();
		
		
		if (null!= request.getPlanName() && !"".equals(request.getPlanName()) )
		{
			entity.setPlanName(request.getPlanName());
		}
		
		if (null!= request.getPlanStatus() && !"".equals(request.getPlanStatus())) 
		{
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if (null!= request.getGender() && !"".equals(request.getGender()) )
		{
			entity.setGender(request.getGender());
		}
		if (null!= request.getStartDate() && !"".equals (request.getStartDate()) )
		{
			String starDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localdate = LocalDate.parse(starDate ,formatter );
			entity.setPlanStartDate(localdate);
		}
		
		if (null!= request.getEndDate() && !"".equals(request.getEndDate()) )
		{
			String EndDate= request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//convert string to localDate
			LocalDate localdate =LocalDate.parse(EndDate, formatter);
			entity.setPlanEndDate(localdate);
		}
		
		return repo.findAll(Example.of(entity));
		
		
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception{
	 // List <CitizenPlan> plans= repo.findAll();
		File f= new File("Plans.xls");
		generator.generate(response, f);
	   String subject ="Test Mail subject";
	   String body= "<h1> Test mail boday</h1>";
	   String to= "ltajay60@gmail.com";
	   
	   
	   emailUtils.sendEmail(subject, body, to,f);
	   
		f.delete();//delete file from my server 
	  return true;
		
	}
	
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		File f= new File("Plans.pdf");
		genpdf.generate(response , f);
		 String subject ="Test Mail subject";
		   String body= "<h1> Test mail boday</h1>";
		   String to= "ltajay60@gmail.com";
		   
		   
		   emailUtils.sendEmail(subject, body, to,f);
		   
			f.delete();//
		return true;
	}

}
