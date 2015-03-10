package com.gestionTournoi.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import com.gestionTournoi.dao.LoginDAO;
import com.gestionTournoi.dao.OrganisateurDAO;
import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.dao.RolesDAO;
import com.gestionTournoi.metiers.Login;
import com.gestionTournoi.metiers.Organisateur;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.RolePK;
import com.gestionTournoi.metiers.Roles;

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

	public String enregistrer() {
		HttpSession httpSession = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory) httpSession.getServletContext()
				.getAttribute("EntityManager");
		Session session = sf.openSession();
				
		System.out.println("Je suis  la!! " + type);
		
		if (type.equals("Participant")) {
			ParticipantDAO pDAO = new ParticipantDAO();
			pDAO.setSession(session);

			LoginDAO lDAO = new LoginDAO();
			lDAO.setSession(session);

			RolesDAO rDAO = new RolesDAO();
			rDAO.setSession(session);

			Login log = new Login();
			log.setLogin(login);
			log.setMdp(mdp);

			try {
				lDAO.insert(log);

				Roles role = new Roles();
				RolePK rPK = new RolePK();

				rPK.setLogin(log);
				rPK.setRole("participant");
				role.setPk(rPK);

				rDAO.insert(role);

				Participant p = new Participant();
				p.setLogin(login);
				p.setNom(login);
				p.setMdp(mdp);

				pDAO.insert(p);

				session.close();
				
				return "participant";
			} catch (ConstraintViolationException ex) {
				System.out.println("Je leve");

				FacesMessage msgs = new FacesMessage("Login Déjà Utilisé");
	
				FacesContext.getCurrentInstance().addMessage(null, msgs);
				
				return "new";
			}

		} else if (type.equals("Organisateur")) {
			OrganisateurDAO oDAO = new OrganisateurDAO();
			oDAO.setSession(session);

			RolesDAO rDAO = new RolesDAO();
			rDAO.setSession(session);

			LoginDAO lDAO = new LoginDAO();
			lDAO.setSession(session);

			Login log = new Login();
			log.setLogin(login);
			log.setMdp(mdp);

			lDAO.insert(log);

			Roles role = new Roles();
			RolePK rPK = new RolePK();

			rPK.setLogin(log);
			rPK.setRole("organisateur");
			role.setPk(rPK);

			rDAO.insert(role);

			Organisateur org = new Organisateur();

			org.setNom(login);
			org.setMdp(mdp);

			oDAO.insert(org);

			session.close();

			return "organisateur";
		} else {
			return null;
		}

	}
}
