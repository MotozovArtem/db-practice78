package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 * TODO ArMotozov
 *
 * @since 11/26/2022
 */
@Entity
@Table(name = "app_role")
public class Role implements GrantedAuthority {

	@Id
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(targetEntity = User.class, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<User> usersWithRole;

	public Role() {
	}

	public Role(Integer id, String name, Set<User> usersWithRole) {
		this.id = id;
		this.name = name;
		this.usersWithRole = usersWithRole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsersWithRole() {
		return usersWithRole;
	}

	public void setUsersWithRole(Set<User> usersWithRole) {
		this.usersWithRole = usersWithRole;
	}

	@Override
	public String getAuthority() {
		return getName();
	}
}
