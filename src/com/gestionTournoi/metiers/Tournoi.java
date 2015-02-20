package com.gestionTournoi.metiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tournoi {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nom;
	@Column
	private int nbInscrit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbInscrit() {
		return nbInscrit;
	}

	public void setNbInscrit(int nbInscrit) {
		this.nbInscrit = nbInscrit;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if(this.id == ((Tournoi) obj).id) {
	        return true;
	    }else {
	        return false;
	    }
	}
	
}
