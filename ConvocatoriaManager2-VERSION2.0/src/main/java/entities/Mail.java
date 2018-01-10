package main.java.entities;

import java.io.Serializable;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.Part;

import main.java.entities.Settings;
import main.java.services.SettingsServices;



public class Mail implements Serializable {

	private static final long serialVersionUID = 1L;

	
	String toAddress;
	String subject;
	String bodyMessage;
	private Part file1;


	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBodyMessage() {
		return bodyMessage;
	}

	public void setBodyMessage(String bodyMessage) {
		this.bodyMessage = bodyMessage;
	}


	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}

	@Override
	public String toString() {
		return "Mail [toAddress=" + toAddress + ", subject=" + subject + ", bodyMessage=" + bodyMessage + ", file1="
				+ file1 + "]";
	}

	
	
}
