package main.java.entities;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;

public class MailSimple implements Serializable {

	private static final long serialVersionUID = 1L;

	final String from = "appstaffmanagement@gmail.com";
	final String userName = "appstaffmanagement@gmail.com";// change accordingly
	final String password = "Matinhos-1982";// change accordingly
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

	public String getFrom() {
		return from;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
