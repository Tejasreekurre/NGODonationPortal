package com.cg.ndp.model;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AdminModel implements Serializable {
	private static final long serialVersionUID = 1L;


	private int adminId;

	@NotEmpty(message = "Admin UserName cannot be empty")
	@NotNull(message = "Admin UserName cannot be omitted")
	private String adminUsername;

	@JsonIgnore
	@Pattern(regexp="(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required")
	@NotNull(message="Admin Password cannot be omitted")
	private String adminPassword;

	public AdminModel() {
		/* default constructors */

	}

	public AdminModel(int adminId,
			@NotEmpty(message = "Admin UserName cannot be empty") @NotNull(message = "Admin UserName cannot be omitted") String adminUsername,
			@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required") @NotNull(message = "Donor Password cannot be omitted") String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result + ((adminPassword == null) ? 0 : adminPassword.hashCode());
		result = prime * result + ((adminUsername == null) ? 0 : adminUsername.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminModel other = (AdminModel) obj;
		if (adminId != other.adminId)
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		if (adminUsername == null) {
			if (other.adminUsername != null)
				return false;
		} else if (!adminUsername.equals(other.adminUsername))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Admin [adminId=%s, adminUsername=%s, adminPassword=%s]", adminId, adminUsername,
				adminPassword);
	}

}