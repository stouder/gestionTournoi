package com.gestionTournoi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionTournoi.metiers.Inscription;
import com.gestionTournoi.metiers.Tournoi;



public class TournoiDAO implements GenericDAO<Tournoi> {

	private Session session;
	
	public void setSession(Session s){
		this.session = s;
	}
	
	@Override
	public void insert(Tournoi tournoi) {
		Transaction tx = session.beginTransaction();
		session.save(tournoi);
		tx.commit();
	}


	@Override
	public List<Tournoi> getAll() {
		Query query = session.createQuery("from Tournoi");
		List liste = query.list();
		
		return liste;
	}
	
	
	
}
