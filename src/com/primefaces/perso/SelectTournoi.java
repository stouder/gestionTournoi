package com.primefaces.perso;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.gestionTournoi.metiers.Tournoi;

@ManagedBean
public class SelectTournoi {
	private Tournoi Tournoi;
	private List<Tournoi> tournois;
	private String nom;

	@ManagedProperty("#{listeTournois}")
	private ListeTournois service;

	@PostConstruct
	public void init() {
		tournois = service.getTournois();
	}

	public Tournoi getTournoi() {
		return Tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		Tournoi = tournoi;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



}
