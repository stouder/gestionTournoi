package com.gestionTournoi.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.OrganisateurDAO;
import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.metiers.Organisateur;
import com.gestionTournoi.metiers.Participant;

@ManagedBean
public class NouveauUtilisateur {
	private String login;
	private String mdp;
	private String type;
	
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String enregistrer(){
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory)httpSession.getServletContext().getAttribute("EntityManager");
		Session session = sf.openSession();
		
		System.out.println("Je suis  la!!" + type);
		if(type.equals("Participant")){
			ParticipantDAO pDAO = new ParticipantDAO();
			pDAO.setSession(session);
			
			Participant p = new Participant();
			p.setLogin(login);
			p.setNom(login);
			p.setMdp(mdp);
			
			pDAO.insert(p);
			
			session.close();
			
			return "participant";
		}else if(type.equals("Organisateur")){
			OrganisateurDAO oDAO = new OrganisateurDAO();
			oDAO.setSession(session);
			
			Organisateur org = new Organisateur();
			
			org.setLogin(login);
			org.setNom(login);
			org.setMdp(mdp);
			
			oDAO.insert(org);
			
			session.close();
			
			return "organisateur";
		}else{
			return null;
		}
		
		
	}
}
