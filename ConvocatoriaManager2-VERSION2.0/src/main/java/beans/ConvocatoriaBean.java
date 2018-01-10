package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import main.java.entities.Player;

@ManagedBean(name = "conv")
@RequestScoped
public class ConvocatoriaBean {

	List<Player> convocados = new ArrayList<>();
	List<Player> naoConvocados = new ArrayList<>();

	public List<Player> getConvocados() {
		return convocados;
	}

	public void setConvocados(List<Player> convocados) {
		this.convocados = convocados;
	}

	
	public List<Player> getNaoConvocados() {
		return naoConvocados;
	}

	public void setNaoConvocados(List<Player> naoConvocados) {
		this.naoConvocados = naoConvocados;
	}
	
	public void removerConvocatoria() {
		
		
	}
	

}
