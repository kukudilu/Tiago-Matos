package main.java.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import main.java.entities.Calendar;
import main.java.services.CalendarServices;

@ManagedBean(name = "cal")
@SessionScoped
public class CalendarioBean {

	private List<Calendar> calList = new ArrayList<>();
	CalendarServices calServ = new CalendarServices();
	private Calendar calendar = new Calendar();

	public CalendarioBean() {

		calList = calServ.readCalendar();
	}

	public List<Calendar> getCalList() {
		return calList;
	}

	public void setCalList(List<Calendar> calList) {
		this.calList = calList;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	


	public String goToUpdateForm(Calendar e) {

		
		//System.out.println("Antes de:  "+ e.toString());
		
		this.calendar = e;
		
		//System.out.println("Depois de: " + calendar.toString());

		return "updateResult.xhtml";
	}
	
	public String updateResult() {
		
		calServ.updateCalendar(calendar);
		
		return "index.xhtml";
		
		
		
	}

}
