package com.gestionTournoi.managedBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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

	public void serviceChange(){
		if(list.add(testSelected) == false)
			System.out.println("Element "+ testSelected +" deja dans la liste");
		System.out.println("Change");
		for(String el:list){
			System.out.println("Liste Test de serie" + el);
		}
	}
}
