package com.gestionTournoi.metiers;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RolePK implements Serializable {
	private String login;
	private String role;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
