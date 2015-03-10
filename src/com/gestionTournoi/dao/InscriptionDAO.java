package com.gestionTournoi.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestionTournoi.metiers.Inscription;
import com.gestionTournoi.metiers.Participant;

public class InscriptionDAO implements GenericDAO<Inscription> {

	private Session session;

	public void setSession(Session s) {
		this.session = s;
	}

	@Override
	public void insert(Inscription Object) {
		Transaction tx = session.beginTransaction();
		session.save(Object);
		tx.commit();

	}

	@Override
	public List<Inscription> getAll() {
		Query req1 = session.createQuery("from Inscription i order by i.classement");
		
		List<Inscription> list = req1.list();
		for(Inscription i:list){
			System.out.println("i" + i.getParticpant().getNom());
		}
		
		return list;
	}
	
	public void update(Inscription Object) {
		System.out.println("update");
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(Object);
		tx.commit();
	}
	
	public boolean dejaInscrit(Participant p){
		Query q1 = session.createQuery("from Inscription i where i.particpant = " +p.getId());
		List<Inscription> list = q1.list();
		
		for(Inscription i:list)
			System.out.println("Premier element de la liste " + i.getId());
		
		if(list.size() == 0){
			System.out.println("Pas Present");
			return false;
		}else{
			System.out.println("Present");
			return true;
		}
	}
}
