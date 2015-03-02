package com.gestionTournoi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionTournoi.metiers.Roles;

public class RolesDAO implements GenericDAO<Roles> {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void insert(Roles roles) {
		Transaction tx = session.beginTransaction();
		session.save(roles);
		tx.commit();
	}

	@Override
	public List<Roles> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
