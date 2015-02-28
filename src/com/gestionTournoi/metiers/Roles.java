package com.gestionTournoi.metiers;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Roles {
	@EmbeddedId
	@AttributeOverrides(value = {
			@AttributeOverride(name = "login", column = @Column(name = "Login")),
			@AttributeOverride(name = "role", column = @Column(name = "role")) })
	private RolePK pk;
}
