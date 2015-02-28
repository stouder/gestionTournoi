package com.gestionTournoi.managedBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.gestionTournoi.dao.InscriptionDAO;
import com.gestionTournoi.metiers.Inscription;
import com.primefaces.perso.ListeInscrits;

@ManagedBean
@SessionScoped
public class FicheTournoiBean {
	private List<Inscription> inscrits;

	@ManagedProperty("#{listeInscrits}")
	private ListeInscrits service;

	private String test;
	private String testSelected;
	private Set<String> list = new HashSet<String>();

	@PostConstruct
	public void init() {
		inscrits = service.getInscrits();
	}

	public List<Inscription> getInscrits() {
		return inscrits;
	}

	public void setInscrits(List<Inscription> inscrits) {
		this.inscrits = inscrits;
	}

	public ListeInscrits getService() {
		return service;
	}

	public void setService(ListeInscrits service) {
		this.service = service;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getTestSelected() {
		return testSelected;
	}

	public void setTestSelected(String testSelected) {
		this.testSelected = testSelected;
	}

	public void onRowEdit(RowEditEvent event) {
		
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		SessionFactory sessionFactory = (SessionFactory) session
				.getServletContext().getAttribute("EntityManager");
		Session s = sessionFactory.openSession();
		InscriptionDAO iDAO = new InscriptionDAO();
		iDAO.setSession(s);
		
		Inscription inscription = (Inscription) event.getObject();
		String tds = inscription.getTeteDeSerie();
		
		inscription.setTeteDeSerie(tds);
		iDAO.update(inscription);
		s.close();
		
		System.out.println( "Edit Inscription tds " +((Inscription) event.getObject()).getTeteDeSerie());
		
	}

	public void onRowCancel(RowEditEvent event) {

	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
		System.out.println("Old Value" + oldValue);
		
//		if (newValue != null && !newValue.equals(oldValue)) {
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//			FacesContext.getCurrentInstance().addMessage(null, msg);
//		}
	}

	public void serviceChange(AjaxBehaviorEvent event) {
		// System.out.println("Test Event Ajax " + this.getTestSelected());

		FacesMessage msg = new FacesMessage("Succès de l'inscription !");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		// if(list.add(testSelected) == false){
		// System.out.println("Element "+ testSelected +" deja dans la liste");
		// FacesContext context = FacesContext.getCurrentInstance();
		// FacesMessage message = new FacesMessage();
		// message.setSummary("Element "+ testSelected +" deja dans la liste");
		// context.addMessage(null, message);
		// }

		// System.out.println("Change");
		// for(String el:list){
		// System.out.println("Liste Test de serie" + el);
		// }

	}

	public void testChange(ValueChangeEvent e) {
		//System.out.println("Fa Changement");
		//System.out.println("Ancienne Valeur" + e.getOldValue());
		if (list.add((String) e.getNewValue()) == false) {
			list.remove(e.getOldValue());

			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSummary("Element " + testSelected
					+ " deja dans la liste");
			context.addMessage(null, message);
		}

		for (String el : list) {
			System.out.println("Liste Test de serie" + el);
		}
		
		
	}
	
	public void onRowSelect(SelectEvent event) {
			System.out.println( "Inscription id " +((Inscription) event.getObject()).getId());
//        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
}
