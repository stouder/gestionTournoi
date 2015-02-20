package com.gestionTournoi.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.InscriptionDAO;
import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.metiers.Inscription;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Tournoi;
import com.primefaces.perso.ListeTournois;

@ManagedBean(name="inscriptionBean")
public class InscriptionBean {
	private Tournoi tournoi;
	private List<Tournoi> tournois;
	private String nom;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ListeTournois getService() {
		return service;
	}

	public void setService(ListeTournois service) {
		this.service = service;
	}

	public String valider(){
		
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory)httpSession.getServletContext().getAttribute("EntityManager");
		Session session = sf.openSession();
		
		Participant p1 = new Participant();
		p1.setNom("Fabien 1");
		
		ParticipantDAO pDAO = new ParticipantDAO();
		pDAO.setSession(session);
		pDAO.insert(p1);
		
		InscriptionDAO iDAO = new InscriptionDAO();
		iDAO.setSession(session);
		Inscription inscription = new Inscription();
		inscription.setTournoi(tournoi);
		inscription.setParticpant(p1);
		
		System.out.println("Tournoi : " + tournoi);
		
		iDAO.insert(inscription);
		
		return null;
	}
	
}
