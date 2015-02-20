package com.gestionTournoi.managedBean;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Rencontre;

@ManagedBean
public class Ajout {
	private String nom;
	private Rencontre rencontre;

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

	public String valider() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session
				.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();
		
		//System.out.println("valider");
		ParticipantDAO pDAO = new ParticipantDAO();
		pDAO.setSession(s);
		
		Participant p = new Participant();
		p.setNom(nom);
		
		//Set<Rencontre> liste = new HashSet<Rencontre>();
		//liste.add(rencontre);
		//System.out.println("Rencontre Ajout : " + rencontre);
		//p.setRencontres(liste);
		
		//pDAO.insert(p);
		
		return null;

	}
}
