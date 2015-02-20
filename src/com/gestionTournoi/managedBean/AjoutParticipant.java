package com.gestionTournoi.managedBean;

import java.util.HashSet;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Rencontre;

public class AjoutParticipant {
	private String nom;
	private Rencontre rencontre;
	private Set<Rencontre> rencontres;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Rencontre getRencontre() {
		return rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	public Set<Rencontre> getRencontres() {
		return rencontres;
	}

	public void setRencontres(Set<Rencontre> rencontres) {
		this.rencontres = rencontres;
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
		
		System.out.println("rencontre : " + rencontres);
		
		//Set<Rencontre> liste = new HashSet<Rencontre>();
		//rencontres.add(rencontre);
		//p.setRencontres(rencontres);
		
		pDAO.insert(p);

		return null;

	}
}
