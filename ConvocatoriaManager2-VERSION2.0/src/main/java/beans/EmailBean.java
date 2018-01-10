package main.java.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import main.java.entities.Mail;
import main.java.entities.MailSimple;
import main.java.services.MailServices;

@ManagedBean(name = "email")
@RequestScoped
public class EmailBean {

	private Mail newMail;
	MailServices mailServ = new MailServices();

	public EmailBean() {

		newMail = new Mail();
	}

	public String sendMail() {

		System.out.println("CENAS " + newMail.getFile1());

		if (newMail.getFile1()==null) {

			mailServ.sendMailSimple(newMail);

		} else {

			mailServ.sendMail(newMail);
		}

		System.out.println(newMail);

		return "index";
	}

	public Mail getNewMail() {
		return newMail;
	}

	public void setNewMail(Mail newMail) {
		this.newMail = newMail;
	}

}
