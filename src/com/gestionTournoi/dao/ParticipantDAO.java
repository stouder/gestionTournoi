package com.gestionTournoi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Rencontre;

public class ParticipantDAO implements GenericDAO<Participant> {

	private Session session;
	
	public void setSession(Session s){
		this.session = s;
	}
	
	@Override
	public void insert(Participant p) {
		
		Transaction tx = session.beginTransaction();
	
		for(Rencontre r:p.getRencontres()){
			System.out.println("Rencontre dans Dao Participant : " + r.getNom());
		}
		
		session.save(p);
		tx.commit();
		System.out.println("OK insert participant!!!");
	}

	@Override
	public List<Participant> getAll() {
		Query query = session.createQuery("from Participant");
		List<Participant> participants = query.list();
		return participants;
	}
}
