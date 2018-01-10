package main.java.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HideShowBean {

	private boolean validate;

	public void show() {

		this.validate = true;
	}

	public void hide() {

		this.validate = false;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

}
