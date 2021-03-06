package com.gestionTournoi.metiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Inscription")
public class Inscription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Tournoi tournoi;
	@ManyToOne
	private Participant particpant;
	@Column
	private int fraisInscription;
	@Column
	private String teteDeSerie;
	@Column
	private String classement;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeteDeSerie() {
		return teteDeSerie;
	}
	public void setTeteDeSerie(String teteDeSerie) {
		this.teteDeSerie = teteDeSerie;
	}
	public Tournoi getTournoi() {
		return tournoi;
	}
	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}
	public Participant getParticpant() {
		return particpant;
	}
	public void setParticpant(Participant particpant) {
		this.particpant = particpant;
	}
	public int getFraisInscription() {
		return fraisInscription;
	}
	public void setFraisInscription(int fraisInscription) {
		this.fraisInscription = fraisInscription;
	}
	public String getClassement() {
		return classement;
	}
	public void setClassement(String classement) {
		this.classement = classement;
	}
		
}
