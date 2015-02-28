package com.gestionTournoi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionTournoi.metiers.Organisateur;

public class OrganisateurDAO implements GenericDAO<Organisateur> {
	
	private Session session;
	
	public void setSession(Session s){
		session =s;
	}
	
	@Override
	public void insert(Organisateur org) {
		Transaction tx = session.beginTransaction();
		session.save(org);
		tx.commit();
		
	}

	@Override
	public List<Organisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
