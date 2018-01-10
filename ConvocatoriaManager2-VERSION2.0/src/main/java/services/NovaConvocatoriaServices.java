package main.java.services;


import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.connection.HibernateUtil;
import main.java.entities.Convocatoria;
import main.java.entities.Player;

public class NovaConvocatoriaServices {

	@Inject
	HibernateUtil conn;

	public NovaConvocatoriaServices() {

		conn = new HibernateUtil();
	}

	public boolean existeConvocatoria(Convocatoria c) {

		try {

			conn.setUp();
			SessionFactory sessionFactory = conn.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// Recebe todas as convocatorias existentes
			TypedQuery<Convocatoria> lQuery = session.createQuery("from Convocatoria", Convocatoria.class);
			List<Convocatoria> convList = lQuery.getResultList();

			// Verifica se a convocatória a ser gravada já existe

			for (Convocatoria co : convList) {

				if (co.getJornada() == c.getJornada()) {

					System.out.println("Esta Convocatória já existe...");

					return true;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;

	}

	public void gravarNovaConvocatoria(Convocatoria c, Set<Player> playersConv) {

		try {

			conn.setUp();
			SessionFactory sessionFactory = conn.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// Recebe todas as convocatorias existentes
			TypedQuery<Convocatoria> lQuery = session.createQuery("from Convocatoria", Convocatoria.class);
			List<Convocatoria> convList = lQuery.getResultList();

			// Verifica se a convocatória a ser gravada já existe

			for (Convocatoria co : convList) {

				if (co.getJornada() == c.getJornada()) {

					FacesContext.getCurrentInstance().addMessage("convocadosForm:growlSpecific2",
							new FacesMessage("Convocatória para esta jornada já existente."));

					return;
				}
			}

			for (Player p : playersConv) {

				p.setNumOfCalls((p.getNumOfCalls() + 1));
				p.setNotCalls(0);
				System.out.println(p);
				session.merge(p);
				c.getConvocados().add(p);

			}

			session.saveOrUpdate(c);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Atualizar também as não convocatorias

		gravarNaoConvocatorias();

	}

	public void gravarNaoConvocatorias() {

		HibernateUtil hbu = new HibernateUtil();
		try {
			hbu.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SessionFactory sessionFactory = hbu.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Obter numero de ultima jornada disputada

		TypedQuery<Convocatoria> lQuery2 = session.createQuery("from Convocatoria", Convocatoria.class);
		List<Convocatoria> convList = lQuery2.getResultList();

		int ultimaJornada = 0;

		for (Convocatoria c : convList) {

			if (c.getJornada() >= ultimaJornada) {

				ultimaJornada = c.getJornada();
			}
		}

		// Receber lista de todos os jgadores -- CHECKED!
		TypedQuery<Player> lQuery = session.createQuery("from Player", Player.class);
		List<Player> playerList = lQuery.getResultList();

		// Ver os jogos em que cada jogador participou -- CHECKED!

		for (Player p : playerList) {

			// Obtenção de todos os jogos em que o jogador foi convocado
			List<Convocatoria> convocado = p.getConvocado();

			// Obter ultimo jogo em que jogador participou

			int ultimaConvocatoria = 0;

			for (Convocatoria c : convocado) {

				if (c.getJornada() >= ultimaConvocatoria) {

					ultimaConvocatoria = c.getJornada();

				}

			}

			// Calcula nº de jogos sem que jogador seja convocado
			int naoConvocado = ultimaJornada - ultimaConvocatoria;

			/*
			 * System.out.println("Jogador: " + p.getfName() + " " + p.getlName());
			 * System.out.println("Não convocado há: " + naoConvocado + " jogos.");
			 * System.out.println("Ultima jornada: "+ultimaConvocatoria+"\n");
			 */

			p.setNotCalls(naoConvocado);
			session.update(p);

		}

		session.getTransaction().commit();

		session.close();

	}

}
