package com.gestionTournoi.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.gestionTournoi.metiers.Tournoi;
import com.primefaces.perso.ListeTournois;

@ManagedBean
@SessionScoped
public class OrganisateurBean {
	private Tournoi tournoi;
	private List<Tournoi> tournois;
	
	@ManagedProperty("#{listeTournois}")
	private ListeTournois service;

	@PostConstruct
	public void init() {
		tournois = service.getTournois();
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public List<Tournoi> getTournois() {
		return tournois;
	}

	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}

	public ListeTournois getService() {
		return service;
	}

	public void setService(ListeTournois service) {
		this.service = service;
	}
	
	public String valider(){
		return "tournoi";
	}
}
