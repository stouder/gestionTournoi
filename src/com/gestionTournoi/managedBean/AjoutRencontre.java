package com.gestionTournoi.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.TournoiDAO;
import com.gestionTournoi.metiers.Tournoi;

@ManagedBean
public class AjoutRencontre {
	private String nom;

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
		
		TournoiDAO tDAO = new TournoiDAO();
		tDAO.setSession(s);
		
		LoginBean loginBean = (LoginBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
		
		if(loginBean == null){
			System.out.println("Login n'existe pas!!");
		}else{
			System.out.println("LoginBean existe!!");
			Tournoi tournoi = new Tournoi();
			tournoi.setNom(loginBean.getLogin());
			tDAO.insert(tournoi);
			s.close();
		}
		
		return "null";
	//	Tournoi tournoi = new Tournoi();
		//tournoi.setNom(LoginBean)
//		RencontreDAO rDAO = new RencontreDAO();
//		rDAO.setSession(s);
//
//		Rencontre r = new Rencontre();
//		r.setNom(nom);
//		rDAO.insert(r);
//		
//		ParticipantDAO pDAO = new ParticipantDAO();
//		pDAO.setSession(s);
//		
//		Participant p = new Participant();
//		pDAO.insert(p);
//		return null;

	}
}
