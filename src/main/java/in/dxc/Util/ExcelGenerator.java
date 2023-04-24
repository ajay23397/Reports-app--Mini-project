package in.dxc.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.dxc.Entity.CitizenPlan;
import in.dxc.Repository.CitizenPlanRepository;

@Component
public class ExcelGenerator {

	
	@Autowired
	private CitizenPlanRepository repo;
	
	public void generate(HttpServletResponse response, File file) throws Exception
	{
		List <CitizenPlan> records= repo.findAll();
		Workbook workbook = new HSSFWorkbook();
	    Sheet sheet=workbook.createSheet("plans-data");	
		 Row headerRow = sheet.createRow(0);
		 headerRow .createCell(0).setCellValue("ID");
		 headerRow.createCell(1).setCellValue("Ctizen Name");
		 headerRow.createCell(2).setCellValue("gender");
		 headerRow.createCell(3).setCellValue("planName");
		 headerRow.createCell(4).setCellValue("planStatus");
		 headerRow.createCell(4).setCellValue("planStartDate");
		 headerRow.createCell(4).setCellValue("planEndDate");
		 
		 List <CitizenPlan> Records = repo.findAll();
		        
		 int dataRowindex=1;
		 for (CitizenPlan plan : records)
		 {
			 
			 Row dataRow=sheet.createRow(dataRowindex);
			 
			 dataRow.createCell(0).setCellValue(plan.getCitizenId());
			     dataRow.createCell(1).setCellValue(plan.getCitizenName());
			     dataRow.createCell(2).setCellValue(plan.getGender());
			     dataRow.createCell(3).setCellValue(plan.getPlanName());
			     dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			     dataRow.createCell(3).setCellValue(plan.getPlanStartDate());
			     dataRow.createCell(3).setCellValue(plan.getPlanEndDate());
			     dataRowindex++;
			   	}
		 
		 /*
		  * workbook i am writing to file output stream to send to email
		  * wrokbook i am writing to servlet output stream to send to browser
		  * 
		  */
		 ServletOutputStream  outputstream = response.getOutputStream();
		 workbook.write(outputstream); 
		 workbook.close();
		 

	 	  //FileOutputStream fos= new FileOutputStream(new File("plans.xls"));   
	 	  FileOutputStream fos= new FileOutputStream(file);
			 workbook.write(fos);
			  workbook.close();

		
	}
}
