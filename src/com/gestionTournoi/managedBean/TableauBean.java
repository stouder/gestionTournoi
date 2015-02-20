package com.gestionTournoi.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gestionTournoi.dao.ParticipantDAO;
import com.gestionTournoi.metiers.Participant;

@ManagedBean
public class TableauBean {
	private List<Participant> participant1Tour;

	public List<Participant> getParticipant1Tour() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session
				.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();
		
		ParticipantDAO pDAO = new ParticipantDAO();
		pDAO.setSession(s);
		
		List<Participant> participant1Tour = pDAO.getAll();
		return participant1Tour;
	}

	public void setParticipant1Tour(List<Participant> participant1Tour) {
		this.participant1Tour = participant1Tour;
	}

}
