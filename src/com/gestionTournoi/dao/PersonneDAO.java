package com.gestionTournoi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.gestionTournoi.metiers.Personne;

public class PersonneDAO implements GenericDAO<Personne> {

	private Session session;
	
	public void setSession(Session s){
		this.session = s;
	}
	
	@Override
	public void insert(Personne Object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Personne> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Personne searchLogin(String login){
		Query req = session.getNamedQuery("personne.readByName");
		req.setParameter("login",login);
		//req.setParameter("mdp", mdp);
		
		Personne personne = null;
		for(Personne p:(List<Personne>)req.list()){
			personne = p;
		}
		
		personne = (Personne)req.list().get(0);
		
		return personne;
	}
	
	public Personne login(String login,String mdp){
		Query req = session.getNamedQuery("personne.readByLogin");
		req.setParameter("login",login);
		req.setParameter("mdp", mdp);
		
		Personne personne = null;
		for(Personne p:(List<Personne>)req.list()){
			personne = p;
		}
		
		//Personne personne = (Personne)req.list().get(0);
		
		return personne;
	}
}
