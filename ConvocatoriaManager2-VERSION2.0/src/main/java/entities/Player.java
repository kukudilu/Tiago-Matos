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
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	private int playerId;
	private String fName;
	private String lName;
	private int numOfCalls;
	private int notCalls;
	private boolean ativo;
	private String photoPass;

	private List<Convocatoria> convocado = new ArrayList<Convocatoria>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@ManyToMany(mappedBy = "convocados", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public List<Convocatoria> getConvocado() {
		return convocado;
	}

	public void setConvocado(List<Convocatoria> convocado) {
		this.convocado = convocado;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getNumOfCalls() {
		return numOfCalls;
	}

	public void setNumOfCalls(int numOfCalls) {
		this.numOfCalls = numOfCalls;
	}

	public int getNotCalls() {
		return notCalls;
	}

	public void setNotCalls(int notCalls) {
		this.notCalls = notCalls;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getPhotoPass() {
		return photoPass;
	}

	public void setPhotoPass(String photoPass) {
		this.photoPass = photoPass;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", fName=" + fName + ", lName=" + lName + ", numOfCalls=" + numOfCalls
				+ ", notCalls=" + notCalls + ", ativo=" + ativo + ", photoPass=" + photoPass + ", convocado="
				+ convocado + "]";
	}

	

}
