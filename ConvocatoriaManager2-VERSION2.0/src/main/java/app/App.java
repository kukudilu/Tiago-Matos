package main.java.app;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import main.java.connection.HibernateUtil;
import main.java.entities.Convocatoria;
import main.java.entities.Player;
import main.java.entities.Settings;

public class App {

	public static void main(String[] args) throws Exception {
		
		HibernateUtil conn = new HibernateUtil();
		
Convocatoria c = new Convocatoria();
		
		c.setAdversario("Espinho");
		c.setJornada(7);
	
	
			
			conn.setUp();
			SessionFactory sessionFactory = conn.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			//Recebe todas as convocatorias existentes
			TypedQuery<Convocatoria> lQuery = session.createQuery("from Convocatoria", Convocatoria.class);
			List<Convocatoria> convList = lQuery.getResultList();
			
			
			//Verifica se a convocatória a ser gravada já existe
			
			for(Convocatoria co : convList) {
				
				if(co.getJornada()==c.getJornada()) {
					
						System.out.println("Está a correr bem");

					return;
				}
			}
			
			System.out.println("Até onde sai?");
			


	}
}

