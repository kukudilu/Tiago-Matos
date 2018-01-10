package main.java.services;


import java.util.List;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import main.java.connection.HibernateUtil;
import main.java.entities.Convocatoria;
import main.java.entities.Player;

public class ConvocatoriaServices {

	@Inject
	HibernateUtil conn;

	public ConvocatoriaServices() {

		conn = new HibernateUtil();
	}

	public List<Player> readConvocatoria(Convocatoria c) {

		try {
			conn.setUp();

		} catch (Exception e) {

			e.printStackTrace();
		}

		SessionFactory sessionFactory = conn.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Convocatoria newConv = new Convocatoria();

		Criteria criteria = session.createCriteria(Convocatoria.class);
		newConv = (Convocatoria) criteria.add(Restrictions.eq("jornada", c.getJornada())).uniqueResult();

		if (newConv != null) {

			List<Player> convocados2 = newConv.getConvocados();

			session.getTransaction().commit();
			session.close();

			return convocados2;

		}

		else {

			return null;
		}

	}
	
	public void removerConvocatoria(Convocatoria c) {
		
		

		try {
			conn.setUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		SessionFactory sessionFactory = conn.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		

		session.delete(c);
		session.getTransaction().commit();

		session.close();

	}

}
