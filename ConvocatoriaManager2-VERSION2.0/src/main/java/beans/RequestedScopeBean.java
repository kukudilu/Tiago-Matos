package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import main.java.entities.Calendar;
import main.java.entities.Convocatoria;
import main.java.entities.Player;
import main.java.entities.Settings;
import main.java.services.ConvocatoriaServices;
import main.java.services.PlayerServices;
import main.java.services.SettingsServices;

@ManagedBean(name = "test")
@RequestScoped
public class RequestedScopeBean {
	
	private Calendar calendar = new Calendar();
	private Settings settings = new Settings();
	private Player pl = new Player();
	
	List<Player> convocadosJornada = new ArrayList<>();
	List<Convocatoria> jogosConvocadoList = new ArrayList<>();
	
	ConvocatoriaServices convServ = new ConvocatoriaServices();
	SettingsServices newSet = new SettingsServices();
	PlayerServices plServ = new PlayerServices();

	
	public RequestedScopeBean() {
		
		settings = newSet.listSettings();
	}

	
	public String procurarConvocatoria(Calendar c) {

		this.calendar = c;
		Convocatoria newConv = new Convocatoria();

		newConv.setJornada(c.getCalendarId());
		convocadosJornada = convServ.readConvocatoria(newConv);

		return "convocados.xhtml";

	}
	
	
	public String gravarAtualizacao() {
		
		
		pl.setAtivo(true);
		plServ.atualizarJogador(pl);
		
		
		return "plantel";
		
		
	}


	public String atualizarJogador(Player p) {
		
		
		this.pl = p;

		//System.out.println("Depois da copia: " + pl);

		return "atualizarJogador";

	}

	public List<Player> getConvocadosJornada() {
		return convocadosJornada;
	}

	public void setConvocadosJornada(List<Player> convocadosJornada) {
		this.convocadosJornada = convocadosJornada;
	}

	public String jogosConvocado(Player pl) {

		jogosConvocadoList = pl.getConvocado();

		return "jogosConvocado.xhtml";

	}

	public Settings getSettingsFromDb() {

		settings = newSet.listSettings();

		return settings;

	}

	public String updateSettings() {

		newSet.updateSettings(this.settings);

		return "index";

	}

	public List<Convocatoria> getJogosConvocadoList() {
		return jogosConvocadoList;
	}

	public void setJogosConvocadoList(List<Convocatoria> jogosConvocadoList) {
		this.jogosConvocadoList = jogosConvocadoList;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public Player getPl() {
		return pl;
	}

	public void setPl(Player pl) {
		this.pl = pl;
	}

}
