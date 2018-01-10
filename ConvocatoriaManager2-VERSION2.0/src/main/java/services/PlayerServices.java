package main.java.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import main.java.connection.HibernateUtil;
import main.java.entities.Convocatoria;
import main.java.entities.Player;

public class PlayerServices {

	@Inject
	HibernateUtil conn;

	public PlayerServices() {

		conn = new HibernateUtil();
	}

	public void criarJogador(Player player) {

		try {
			conn.setUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		SessionFactory sessionFactory = conn.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(player);
		session.getTransaction().commit();

		session.close();

	}

	public List<Player> readAllPlayers() {

		try {
			conn.setUp();
			SessionFactory sessionFactory = conn.getSessionFactory();
			Session session = sessionFactory.openSession();

			TypedQuery<Player> lQuery = session.createQuery("from Player", Player.class);
			List<Player> playerList = lQuery.getResultList();

			
		/*	 for (Player p : playerList) {
			  
			 System.out.println("\n--------------------------------");
			 System.out.println("Player Id: " + p.getPlayerId());
			 System.out.println("First name: " + p.getfName());
			 System.out.println("Last name: " + p.getlName());
			 System.out.println("Player was selected: " + p.getNumOfCalls() +
			 " times this season."); 
			 System.out.println("Player wasn´t selected " +  p.getNotCalls() + " times in a row.\n"); 
			
			 
			 }*/
			 

			session.close();
			return playerList;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;

	}

	public void atualizarJogador(Player pl) {

		try {
			conn.setUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		SessionFactory sessionFactory = conn.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(pl);
		session.getTransaction().commit();

		session.close();

	}

	
	public void removerJogador(Player pl) {
		
		//Aqui, "remover" jogador realiza-se fazendo o update do mesmo mudando o estado de 
		// da coluna ativo para false 'b(0)'
		

		try {
			conn.setUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		SessionFactory sessionFactory = conn.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		

		session.update(pl);
		session.getTransaction().commit();

		session.close();

	}

}
