package com.gestionTournoi.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.PersonneDAO;
import com.gestionTournoi.metiers.Personne;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String login;
	private String mdp;
	
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
	
	public String valider(){
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		SessionFactory sf = (SessionFactory)httpSession.getServletContext().getAttribute("EntityManager");
		Session session = sf.openSession();
		
		PersonneDAO pDAO = new PersonneDAO();
		pDAO.setSession(session);
		Personne personne = (Personne)pDAO.login(login,mdp);
		
		//System.out.println("Personne :" + personne.getId());
		
		if(personne != null){
			System.out.println("Yes");
			return "test";
		}
		else{
			System.out.println("No!!!");
			return "null";
		}
		
//		if(login.equals("login") && mdp.equals("mdp"))
//			return "login";
//		else
//			return "paslogin";
	}
	
}
