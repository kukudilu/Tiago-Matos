package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import main.java.entities.Player;
import main.java.services.PlayerServices;

@ManagedBean(name = "plantel")
@ViewScoped
public class PlantelBean extends Thread{

	PlayerServices plServ = new PlayerServices();
	private List<Player> plantelList = new ArrayList<>();
	private Player pl  = new Player();

	public PlantelBean() {

		
		
	
	}
	
	public void run() {
		
		fillPlantelList();
		System.out.println("DENTRO DO RUN!");
		System.out.println(Thread.currentThread().getName());
		System.out.println(plantelList);
	}

	@PostConstruct
	public void fillPlantelList() {

		
		if(plantelList.size()==0) {
			
			System.out.println("DENTRO METODO");
			List <Player> temp = plServ.readAllPlayers();
				
			for(Player p: temp) {
				
				if(p.isAtivo()) {
					
					plantelList.add(p);
				}
				
			}
			
		}
	

	}
	

	public String atualizarJogador(Player p) {

	
		
		this.pl = p;
		
		System.out.println("Depois da copia: " + pl);
		
		
		return "atualizarJogador";

	}

	public String removerJogador(Player pl) {

		pl.setAtivo(false);
		//System.out.println("remover "+pl);
		plServ.removerJogador(pl);
		return "index";

	}
	
	public String criarJogador() {
		
		pl.setAtivo(true);
		
		plServ.criarJogador(pl);
		
		return "index";
	}

	public List<Player> getPlantelList() {
		return plantelList;
	}

	public void setPlantelList(List<Player> plantelList) {
		this.plantelList = plantelList;
	}

	public Player getPl() {
		return pl;
	}

	public void setPl(Player pl) {
		this.pl = pl;
	}

}
