package com.gestionTournoi.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.InscriptionDAO;
import com.gestionTournoi.dao.PersonneDAO;
import com.gestionTournoi.dao.TournoiDAO;
import com.gestionTournoi.metiers.Inscription;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Tournoi;
import com.primefaces.perso.ListeTournois;

@ManagedBean(name="inscriptionBean")
public class InscriptionBean {
	private Tournoi tournoi;
	private List<Tournoi> tournois;
	private String nom;
	private String classement;
	private Participant p;
	
	
	public InscriptionBean() {
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory)httpSession.getServletContext().getAttribute("EntityManager");
		Session session = sf.openSession();
		String nomAuth =  FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		
		PersonneDAO pDAO = new PersonneDAO();
		pDAO.setSession(session);
		p = (Participant)pDAO.searchLogin(nomAuth);
	}
	
	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}
	
	
	public List<Tournoi> getTournois() {
		tournois = new ArrayList<Tournoi>();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();
		
		System.out.println("Id de Participant :" + p.getId());
		
		Query query = s.getNamedQuery("tournoi.readByTournoiNonInscrit");
		query.setParameter("id", p.getId());
		tournois = query.list();

		s.close();
		
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
	
	public String getClassement() {
		return classement;
	}

	public void setClassement(String classement) {
		this.classement = classement;
	}

	public String valider(){
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory)httpSession.getServletContext().getAttribute("EntityManager");
		Session session = sf.openSession();
		String nomAuth =  FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		
//		Query query = session.getNamedQuery("Personne.readByName");
//		query.setParameter("login",nomAuth);
//		Participant p = (Participant)query.list().get(0);
			
		PersonneDAO pDAO = new PersonneDAO();
		pDAO.setSession(session);
		Participant p = (Participant)pDAO.searchLogin(nomAuth);
		
		InscriptionDAO iDAO = new InscriptionDAO();
		iDAO.setSession(session);
		
		Inscription inscription = new Inscription();
		inscription.setTournoi(tournoi);
		inscription.setParticpant(p);
		inscription.setClassement(classement);
	
		iDAO.insert(inscription);
		
		return null;
	}
	
}
