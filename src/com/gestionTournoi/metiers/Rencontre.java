package com.gestionTournoi.metiers;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rencontre")
public class Rencontre {
	
	public Rencontre() {}
	
	public Rencontre(int id,String nom){
		this.nom = nom;
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_rencontre", unique = true, nullable = false)
	int id;
	//@ManyToMany(mappedBy="rencontres")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Rencontre_Participant", joinColumns = { @JoinColumn(name = "id_rencontre") },  inverseJoinColumns = { @JoinColumn(name = "id_personne") })
	
	private Set<Participant> participants = new HashSet<Participant>(0);
	
	@Column(name="nom")
	private String nom;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if(this.id == ((Rencontre) obj).id) {
	        return true;
	    }else {
	        return false;
	    }
	}

	
}
