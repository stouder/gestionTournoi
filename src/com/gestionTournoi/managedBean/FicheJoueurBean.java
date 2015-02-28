package com.gestionTournoi.managedBean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.gestionTournoi.metiers.Personne;

@ManagedBean
@SessionScoped
public class FicheJoueurBean {
	private String nom;
	
//	public FicheJoueurBean() {
//		
//		boolean conn = false;
//		boolean b = (Boolean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("conn");
//		
//		if(b){
//			conn = (Boolean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conn");
//		}
//			
//		System.out.println("Valeur Boolean " + conn);
//		
//		if(!conn){
//			try{
//				FacesContext.getCurrentInstance().getExternalContext().redirect("Connexion.xhtml");
//			}catch(IOException ex){
//				ex.printStackTrace();
//			}
//		}
//			
//	}
	
	public String getNom() {
//		Personne p =(Personne)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("personne");
//		
//		if(p!=null){
//			String nom = p.getNom();
//		}
		//String nom = p.getNom();
		return nom;
	}

	public void setNom(String nom) {

		this.nom = nom;
	}
	
	
}
