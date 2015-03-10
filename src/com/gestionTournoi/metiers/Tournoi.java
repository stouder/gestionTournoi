package com.gestionTournoi.metiers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries(value={@NamedQuery(name="tournoi.readByTournoiNonInscrit",query="from Tournoi t where t.id not in (select i.tournoi.id from Inscription i where i.particpant.id = :id)"),
		@NamedQuery(name="tournoi.readTournoiByNom", query="from Tournoi t where t.nom = :nom")})

@Table
public class Tournoi {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nom;
	@Column
	private int nbInscrit;
	@Column
	private boolean tAS;
	
	@OneToMany
	@JoinColumn(name="tournoiID")
	private List<Rencontre> rencontres = new ArrayList<Rencontre>();
	
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
	
	public boolean istAS() {
		return tAS;
	}

	public void settAS(boolean tAS) {
		this.tAS = tAS;
	}
	
	public List<Rencontre> getRencontres() {
		return rencontres;
	}

	public void setRencontres(List<Rencontre> rencontres) {
		this.rencontres = rencontres;
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
