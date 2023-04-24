package in.dxc.Util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendEmail(String subject , String boday, String to , File f) {
	try {
		
        MimeMessage mimeMsg=mailsender.createMimeMessage();
		
        MimeMessageHelper helper= new MimeMessageHelper(mimeMsg);
        helper.setSubject(subject);
        helper.setText(boday,true);//if boday contain HTML tag let make it as a true
        helper.setTo(to);
        mailsender.send(mimeMsg);
        helper.addAttachment("plans-Info",f);
       
         
	}
	catch(Exception e)
	
	{
	   e.printStackTrace();	
	}
	return true;
}
}