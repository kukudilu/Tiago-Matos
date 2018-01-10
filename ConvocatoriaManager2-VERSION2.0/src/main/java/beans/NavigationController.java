package main.java.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="nav")
@RequestScoped
public class NavigationController {
	
	public String moveToIndex() {
		
		return "index?faces-redirect=true";
	}

}
