package com.gestionTournoi.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.PersonneDAO;
import com.gestionTournoi.metiers.Organisateur;
import com.gestionTournoi.metiers.Participant;
import com.gestionTournoi.metiers.Personne;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String login;
	private String mdp;
	private HtmlCommandLink boutonConnection;
	
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

	public HtmlCommandLink getBoutonConnection() {
		return boutonConnection;
	}

	public void setBoutonConnection(HtmlCommandLink boutonConnection) {
		this.boutonConnection = boutonConnection;
	}

	public String valider() {
		HttpSession httpSession = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory) httpSession.getServletContext()
				.getAttribute("EntityManager");
		Session session = sf.openSession();

		PersonneDAO pDAO = new PersonneDAO();
		pDAO.setSession(session);
		Personne personne = (Personne) pDAO.login(login, mdp);
		session.close();

		if (personne instanceof Participant) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("personne", personne);
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("conn", true);
			return "participant";
		} else if (personne instanceof Organisateur) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("personne", personne);
			return "organisateur";
		} else {
			FacesMessage msg = new FacesMessage(
					"Erreur de login ou de mot de passe");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);

			return "null";
		}

	}

	public String nouveauUtilisateur() {
		System.out.println("Yes pour le nouveau");
		return "new";
	}

	public String logOut() {
		if(boutonConnection != null){
			this.boutonConnection.setDisabled(true);
		}
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest) externalContext
				.getRequest();
		request.getSession(false).invalidate();
		
		System.out.println("Deconnecter");
		
		return null;
	}
		
}
