package com.gestionTournoi.metiers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Organisateur")
@PrimaryKeyJoinColumn(name = "id_personne")
public class Organisateur extends Personne {
	
	@OneToMany
	private List<Tournoi> tournoi;
}
