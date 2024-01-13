package com.example.mail.service.impl;

import org.eclipse.angus.mail.handlers.multipart_mixed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.mail.service.EmailService;

import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmalServiceImpl implements EmailService{
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			
			mimeMessageHelper.setFrom(fromEmail);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setCc(cc);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);
			
			for(int i=0 ; i<file.length; i++) {
				mimeMessageHelper.addAttachment(
						file[i].getOriginalFilename(),
						new ByteArrayResource(file[i].getBytes())
						);
			}
			
			javaMailSender.send(mimeMessage);
			
			return "Mail Sent";
			
		}catch (Exception e) {
			throw new RuntimeException(e);
	}
	}
}


	