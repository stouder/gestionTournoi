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
		//Query req = session.createQuery("from Inscription i join i.participant");
		//List<Inscription> liste = req.list();
		
//		for(Iterator ite = (Iterator) liste.iterator();ite.hasNext();){
//			Object[] inscritEtParticipant = (Object[])ite.next();
//			
//			Inscription i = (Inscription)inscritEtParticipant[0];
//			Participant p = (Participant)inscritEtParticipant[1];
//			
//			System.out.println("Nom des inscrits : " + p.getNom());
//		}
		
		Query req1 = session.createQuery("from Inscription");
		List<Inscription> list = req1.list();
		for(Inscription i:list){
			System.out.println("i" + i.getParticpant().getNom());
		}
		
		return list;
	}

}
