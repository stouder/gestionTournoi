package com.gestionTournoi.managedBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Rencontre;
import com.primefaces.perso.ThemeService;

@ManagedBean
public class SelectOneMenuView {

	private Rencontre rencontre;
	private List<Rencontre> rencontres;
	private String nom;
	
	@ManagedProperty("#{themeRencontre1}")
	private ThemeService service;

	@PostConstruct
	public void init() {
		rencontres = service.getRencontres();
	}

	public Rencontre getRencontre() {
		return rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	public List<Rencontre> getRencontres() {
		return rencontres;
	}
  
	public void setRencontres(List<Rencontre> rencontres) {
		this.rencontres = rencontres;
	}

	public ThemeService getService() {
		return service;
	}

	public void setService(ThemeService service) {
		this.service = service;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
