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

import com.gestionTournoi.dao.RencontreDAO;
import com.gestionTournoi.metiers.Rencontre;

@ManagedBean(name = "listeRencontres")
@ApplicationScoped
public class ListeRencontres {
	private List<Rencontre> rencontres;
	
	public ListeRencontres() {
		
	}
	
	@PostConstruct
	public void init() {
		

	}
	
	
	public List<Rencontre> getRencontres() {
		rencontres = new ArrayList<Rencontre>();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();
		
		
		RencontreDAO rDAO = new RencontreDAO();
		rDAO.setSession(s);
		//int taille = rDAO.getAll().size();
		//System.out.println("Taille initial: " + taille);
		
		System.out.println("Construcion de liste Rencontre");
		
		rencontres.addAll(rDAO.getAll());
		s.close();
		return rencontres;
	}
}
