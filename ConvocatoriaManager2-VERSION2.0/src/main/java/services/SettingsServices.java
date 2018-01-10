package main.java.services;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import main.java.connection.HibernateUtil;
import main.java.entities.Settings;

public class SettingsServices {

	@Inject
	HibernateUtil conn;

	@Inject
	Settings settings;

	public SettingsServices() {

		conn = new HibernateUtil();
	}

	public Settings listSettings() {

		try {
			conn.setUp();

		} catch (Exception e) {

			e.printStackTrace();
		}

		SessionFactory sessionFactory = conn.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		settings = (Settings) session.get(Settings.class, 1);

		session.getTransaction().commit();
		session.close();

		return settings;

	}

	public void updateSettings(Settings prop) {

		
		try {
			conn.setUp();

		} catch (Exception e) {

			e.printStackTrace();
		}

		SessionFactory sessionFactory = conn.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(prop);

		session.getTransaction().commit();
		session.close();

		
	}

}
