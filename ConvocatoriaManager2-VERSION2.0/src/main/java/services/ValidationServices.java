package main.java.services;



import main.java.entities.Settings;
import main.java.entities.Validation;

public class ValidationServices {

	
	private Settings settings = new Settings();

	private SettingsServices newSet = new SettingsServices();

	public Boolean validateLogin(Validation v) {
		

		settings = newSet.listSettings();
		
		
		if (v.getUserName().equals(settings.getLogin()) && v.getPassword().equals(settings.getPassword())) {

			return true;

		} else {

			return false;
		}

	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

}
