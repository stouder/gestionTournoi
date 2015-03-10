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

import com.gestionTournoi.dao.TournoiDAO;
import com.gestionTournoi.metiers.Tournoi;

@ManagedBean(name = "listeTournois")
@ApplicationScoped
public class ListeTournois {
	private List<Tournoi> tournois;

	public ListeTournois() {

	}

	@PostConstruct
	public void init() {

	}

	public List<Tournoi> getTournois() {
		tournois = new ArrayList<Tournoi>();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session
				.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();


		TournoiDAO tDAO = new TournoiDAO();
		tDAO.setSession(s);

		//List<Tournoi> list = tDAO.getNonInscritAll();

		//tournois.addAll(tDAO.getNonInscritAll());

		s.close();

		return tournois;
	}

}
