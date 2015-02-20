package com.primefaces.perso;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.InscriptionDAO;
import com.gestionTournoi.metiers.Inscription;
import com.gestionTournoi.metiers.Tournoi;

@ManagedBean(name = "listeInscrits")
@ApplicationScoped
public class ListeInscrits {
	private List<Inscription> inscrits;
	
	public ListeInscrits() {
		
	}
	
	@PostConstruct
	public void init() {
		

	}

	public List<Inscription> getInscrits() {
		inscrits = new ArrayList<Inscription>();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();
		
		System.out.println("Construcion de liste des Inscrits");
		
		InscriptionDAO iDAO = new InscriptionDAO();
		iDAO.setSession(s);
		
		inscrits.addAll(iDAO.getAll());
		
		s.close();
		
		return inscrits;
	}
	
	
	
	
}
