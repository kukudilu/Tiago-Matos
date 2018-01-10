package main.java.beans;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import main.java.entities.Convocatoria;
import main.java.entities.Player;
import main.java.services.ConvocatoriaServices;
import javax.faces.context.FacesContext;
import net.bootsfaces.utils.FacesMessages;
import main.java.services.NovaConvocatoriaServices;

@ManagedBean(name = "novaconv")
@ViewScoped
public class NovaConvocatoriaBean {

	private Set<Player> convocados = new LinkedHashSet<Player>();
	private Convocatoria conv = new Convocatoria();
	NovaConvocatoriaServices novaConvServ = new NovaConvocatoriaServices();
	ConvocatoriaServices convServ = new ConvocatoriaServices();

	public void fillConvocados(Player pl) {

		this.convocados.add(pl);

	}

	public String gravarNovaConvocatoria() {

		boolean convRepetida = novaConvServ.existeConvocatoria(conv);

		if (convRepetida == false) {

			if (convocados.size() <= 12) {

				novaConvServ.gravarNovaConvocatoria(conv, convocados);
				
				return "index";

			} else {

				FacesContext.getCurrentInstance().addMessage("convocadosForm:growlSpecific", new FacesMessage("Foram convocados mais de 12 jogadores!"));
				convocados.clear();
			}

		} else {

			FacesContext.getCurrentInstance().addMessage("convocadosForm:growlSpecific2",new FacesMessage("Convocatória já existente!"));
			convocados.clear();
		}
		
		return null;

		

	}

	public String limparConvocatoria() {

		this.convocados.clear();

		return "novaconvocatoria.xhtml";
	}

	public Set<Player> getConvocados() {
		return convocados;
	}

	public void setConvocados(Set<Player> convocados) {
		this.convocados = convocados;
	}

	public Convocatoria getConv() {
		return conv;
	}

	public void setConv(Convocatoria conv) {
		this.conv = conv;
	}

}
