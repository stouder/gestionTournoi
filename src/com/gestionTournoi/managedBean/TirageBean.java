package com.gestionTournoi.managedBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.InscriptionDAO;
import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.dao.RencontreDAO;
import com.gestionTournoi.dao.TournoiDAO;
import com.gestionTournoi.metiers.Inscription;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Rencontre;
import com.gestionTournoi.metiers.Tournoi;
import com.primefaces.perso.ListeTournois;

@ManagedBean(name="tirageBean")
public class TirageBean {
	private Tournoi tournoi;
	private List<Tournoi> tournois;

	@ManagedProperty("#{listeTournois}")
	private ListeTournois service;

	@PostConstruct
	public void init() {
		tournois = service.getTournois();
	}
	
	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}
	
	
	public List<Tournoi> getTournois() {
		return tournois;
	}

	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}



	public ListeTournois getService() {
		return service;
	}

	public void setService(ListeTournois service) {
		this.service = service;
	}

	public String tirage(){
		
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory)httpSession.getServletContext().getAttribute("EntityManager");
		Session session = sf.openSession();
		
		InscriptionDAO iDAO = new InscriptionDAO();
		iDAO.setSession(session);
		List<Inscription> list = iDAO.getAll();
		
		TournoiDAO tDAO = new TournoiDAO();
		tDAO.setSession(session);
		
		RencontreDAO rDAO = new RencontreDAO();
		rDAO.setSession(session);
		
		ParticipantDAO pDAO = new ParticipantDAO();
		pDAO.setSession(session);
		
		Query reqTournoi = session.getNamedQuery("tournoi.readTournoiByNom");
		Tournoi tournoi = (Tournoi)reqTournoi.setParameter("nom", "Rolland Garros").list().get(0);
		
		//System.out.println("Tournoi : " +tournoi.getNom());
		
		int nbRencontres = tournoi.getNbInscrit()/2;
		
		List<Rencontre> listeRencontre = new ArrayList<Rencontre>();
		Rencontre rencontreCreation;
		
		for(int i=0;i<nbRencontres;i++){
			rencontreCreation = new Rencontre();
			rDAO.insert(rencontreCreation);
			tournoi.getRencontres().add(rencontreCreation);
			tDAO.insert(tournoi);
		}
		
		
		
//		List<Rencontre> listeRencontre = rDAO.getAll();
		
		
		
		for(Inscription l:list){
			System.out.println("Inscription : " + l.getParticpant().getNom());
		}
		
		int nbInscrit = list.size();
		int indexRencontre = listeRencontre.size();
		Participant p;
		Set<Rencontre> r = new HashSet<Rencontre>();
		int max = nbInscrit;
		
		while(max>0){
			Random rand = new Random();
				
			//System.out.println("max " + max);
			
			int min = 0;
			int iRencontre = 0;
			
			int nombreAleatoire = rand.nextInt(max - min) + min;
			if(iRencontre%2 != 0){
				System.out.println("Rentre dans if");
				iRencontre++;
			}
			
			Rencontre rencontre = (Rencontre)listeRencontre.get(iRencontre);
			r.add(rencontre);
			System.out.println("Rencontre id : " + rencontre.getId());
			p = (Participant)list.get(nombreAleatoire).getParticpant();
			
			p.setRencontres(r);
			
			p.getRencontres().add(rencontre);
			rencontre.getParticipants().add(p);
			
			pDAO.insert(p);
			System.out.println("NbInscrt : " + nbInscrit);
			System.out.println(list.get(nombreAleatoire).getId());
			
			list.remove(nombreAleatoire);
			max--;
			if(max==0){
				
			}
		}
		
		return null;
	}
	
}
