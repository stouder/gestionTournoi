package com.gestionTournoi.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.TournoiDAO;
import com.gestionTournoi.metiers.Tournoi;

@ManagedBean
public class TournoiBean {
	
	private String nom;
	private int nbInscrit;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNbInscrit() {
		return nbInscrit;
	}

	public void setNbInscrit(int nbInscrit) {
		this.nbInscrit = nbInscrit;
	}

	public String valider(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session
				.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();
		
		Tournoi tournoi =  new Tournoi();
		tournoi.setNom(nom);
		tournoi.setNbInscrit(nbInscrit);

		TournoiDAO tDAO = new TournoiDAO();
		tDAO.setSession(s);
		tDAO.insert(tournoi);
		
		return null;
		
	}
}
