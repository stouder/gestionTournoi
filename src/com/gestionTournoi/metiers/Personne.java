package com.gestionTournoi.metiers;

import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(value={
		//@NamedQuery(name="personne.readByLogin",query="From Personne p where p.login=:login and p.mdp=:mdp"),
					@NamedQuery(name="personne.readByName",query="From Personne p where p.login=:login")})

@Table(name="Personne")
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_personne", unique = true, nullable = false)
	private int id;

	@Column(name="Nom")
	private String nom;
	
	
	@Column(name="login")
	private String login;
	
	@Column(name="mdp")
	private String mdp;
	
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
	
	
	
}
