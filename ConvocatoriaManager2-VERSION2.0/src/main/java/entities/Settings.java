package main.java.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Settings {

	private int Id;
	private String filePath;
	private String login;
	private String password;

	@Id
	public int getId() {
		return Id;
	}
	
	
	public void setId(int id) {
		Id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Properties [Id=" + Id + ", filePath=" + filePath + ", login=" + login + ", password=" + password + "]";
	}

	
	
}
