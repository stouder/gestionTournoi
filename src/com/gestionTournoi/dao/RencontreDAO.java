
package com.gestionTournoi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionTournoi.metiers.Rencontre;

public class RencontreDAO implements GenericDAO<Rencontre> {

	private Session session;
	
	public void setSession(Session s){
		this.session = s;
	}
	
	@Override
	public void insert(Rencontre r) {
		Transaction tx = session.beginTransaction();
		session.save(r);
		tx.commit();
		
	}

	@Override
	public List<Rencontre> getAll() {
		Query query = session.createQuery("from Rencontre");
		List<Rencontre> liste = query.list();
		
		return liste;
	}
	
	
}
