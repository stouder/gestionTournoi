package com.gestionTournoi.metiers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "Participant")
@PrimaryKeyJoinColumn(name = "id_personne")
public class Participant extends Personne {
	
	public Participant() {

	}
	
	@Column
	private String sport;
	@OneToMany //(mappedBy="participant")
	private List<Inscription> inscription;
	
	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="participants")

	private Set<Rencontre> rencontres = new HashSet<Rencontre>(0);

	public Set<Rencontre> getRencontres() {
		return rencontres;
	}

	public void setRencontres(Set<Rencontre> rencontres) {
		this.rencontres = rencontres;
	}

}
