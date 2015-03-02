package com.gestionTournoi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionTournoi.metiers.Login;

public class LoginDAO implements GenericDAO<Login> {

	private Session session;
	
	public void setSession(Session s) {
		this.session = s;
	}
	
	@Override
	public void insert(Login login) {
		Transaction tx = session.beginTransaction();
		session.save(login);
		tx.commit();
		
	}

	@Override
	public List<Login> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
