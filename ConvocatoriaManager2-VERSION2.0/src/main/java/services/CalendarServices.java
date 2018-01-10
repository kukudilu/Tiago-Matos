package main.java.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import main.java.connection.HibernateUtil;
import main.java.entities.Calendar;


public class CalendarServices {

	@Inject
	HibernateUtil conn;

	public CalendarServices() {
		
		conn = new HibernateUtil();

	}

	public List<Calendar> readCalendar() {

		try {
			conn.setUp();
			SessionFactory sessionFactory = conn.getSessionFactory();
			Session session = sessionFactory.openSession();

			TypedQuery<Calendar> lQuery = session.createQuery("from Calendar", Calendar.class);
			List<Calendar> calendarList = lQuery.getResultList();

			/*for (Calendar c : calendarList) {

				System.out.println("\n--------------------------------");
				System.out.println("Calendar Id: " + c.getCalendarId());
				System.out.println("Jogo: " + c.getGames());
				System.out.println("Resultado: " + c.getResult());
				
			}	
*/
			session.close();
			return calendarList;

		} catch (Exception e) {

			e.printStackTrace();
		}
	
		return null;

	}
	
	public void updateCalendar (Calendar cal)  {

		try {
			conn.setUp();
			SessionFactory sessionFactory = conn.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			System.out.println("Inside calendar" + cal.toString());
			session.update(cal);
			session.getTransaction().commit();
			session.close();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	
	
	
	
	}
	

}
