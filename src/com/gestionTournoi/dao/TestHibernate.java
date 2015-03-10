package com.gestionTournoi.dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.metiers.Tournoi;

public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		InscriptionDAO iDAO = new InscriptionDAO();
		iDAO.setSession(session);
		TournoiDAO tDAO = new TournoiDAO();
		tDAO.setSession(session);

		List<Tournoi> list = tDAO.getAll();
		for (Tournoi t : list)
			System.out.println(t.getNom());

		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();

	}

}
