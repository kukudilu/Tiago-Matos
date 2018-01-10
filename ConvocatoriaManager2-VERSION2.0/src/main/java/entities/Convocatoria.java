package main.java.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Convocatoria implements Serializable {

	private static final long serialVersionUID = 1L;

	private int convId;
	private String adversario;
	private int jornada;

	private List<Player> convocados = new ArrayList<Player>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getConvId() {
		return convId;
	}

	public void setConvId(int convId) {
		this.convId = convId;
	}

	public String getAdversario() {
		return adversario;
	}

	public void setAdversario(String adversario) {
		this.adversario = adversario;
	}

	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.MERGE})
	public List<Player> getConvocados() {
		return convocados;
	}

	public void setConvocados(List<Player> convocados) {
		this.convocados = convocados;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	@Override
	public String toString() {
		return "Convocatoria [convId=" + convId + ", adversario=" + adversario + ", jornada=" + jornada + "]";
	}



}
