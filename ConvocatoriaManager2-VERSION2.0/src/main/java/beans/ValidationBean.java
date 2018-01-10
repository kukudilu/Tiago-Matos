package main.java.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import main.java.entities.Validation;
import main.java.services.ValidationServices;

@ManagedBean(name = "validation")
@RequestScoped
public class ValidationBean {

	private ValidationServices serv = new ValidationServices();
	private Validation val = new Validation();

	public Validation getVal() {
		return val;
	}

	public void setVal(Validation val) {
		this.val = val;
	}
	
	
	public String validateLogin() {

		
		if (serv.validateLogin(val)) {
			
			Thread t1 = new PlantelBean();
			t1.start();
					
			
			return "index";
			
		} else {

			FacesContext.getCurrentInstance().addMessage("loginForm:passwordDiv", new FacesMessage("Invalid Login!"));

			return null;
		}
		
	}
	
}