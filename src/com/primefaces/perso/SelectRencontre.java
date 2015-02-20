package com.primefaces.perso;

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

@ManagedBean
public class SelectRencontre {
	private Rencontre rencontre;
	private List<Rencontre> rencontres;
	private String nom;

	@ManagedProperty("#{listeRencontres}")
	private ListeRencontres service;

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

	public ListeRencontres getService() {
		return service;
	}

	public void setService(ListeRencontres service) {
		this.service = service;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String valider() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session
				.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();

		ParticipantDAO pDAO = new ParticipantDAO();
		pDAO.setSession(s);

		Participant p = new Participant();
		p.setNom(nom);

		Set<Rencontre> liste = new HashSet<Rencontre>();
		liste.add(rencontre);
		
		System.out.println("Taille de liste : " + liste.size());
		
		for(Rencontre r:liste){
			System.out.println("Element de liste : " + r.getNom());
		}
		
		System.out.println("Rencontre Ajout : " + rencontre.getNom());
		
		p.setRencontres(liste);
		
		for(Rencontre r:p.getRencontres()){
			System.out.println("Element de participant-rencontre : " + r.getNom());
		}
		
		p.getRencontres().add(rencontre);
		rencontre.getParticipants().add(p);
		
		pDAO.insert(p);

		return null;

	}

}
