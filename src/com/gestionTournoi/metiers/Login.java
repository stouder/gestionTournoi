package com.gestionTournoi.metiers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")

public class Login {
	@Id
	@Column(name="Login",nullable = false)
	private String login;
	
	@Column(name="mdp", nullable = false)
	private String mdp;

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
