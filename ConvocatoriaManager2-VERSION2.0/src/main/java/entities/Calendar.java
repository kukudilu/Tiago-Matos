package main.java.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calendar {

	private int calendarId;
	private String games;
	private String result;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public String getGames() {
		return games;
	}

	public void setGames(String games) {
		this.games = games;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Calendar [calendarId=" + calendarId + ", games=" + games + ", result=" + result + "]";
	}
	
	

}
