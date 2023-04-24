package in.dxc.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.dxc.Entity.CitizenPlan;
import in.dxc.Repository.CitizenPlanRepository;

@Component
public class PdfGenerator {


	@Autowired
	private CitizenPlanRepository repo;
	
	public void generate(HttpServletResponse response , File f)throws Exception
	{
		
		Document document = new Document(PageSize.A4);
	   PdfWriter.getInstance(document, response.getOutputStream());
	   PdfWriter.getInstance(document,new FileOutputStream(f));
		document.open();
		Paragraph p= new Paragraph("Citizen plans info");
		document.add(p);
		
		PdfPTable table= new PdfPTable(4) ;
		table.addCell("id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		 List<CitizenPlan> plans=repo.findAll();
		for(CitizenPlan plan :plans)
		{
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			
		}
		document.add(table);
		document.close();
		
	}
}
