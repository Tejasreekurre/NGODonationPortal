package com.cg.ndp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class AdminEntity {
	@Id
	@Column(name = "adminId")
	private int adminId;

	@Column(name = "adminUsername")
	private String adminUsername;

	@Column(name = "adminPassword")
	private String adminPassword;

	public AdminEntity() {
		/* default constructors */
	}

	public AdminEntity(int adminId, String adminUsername, String adminPassword) {
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

	public String getAdminpassword() {
		return adminPassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminPassword = adminpassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result + ((adminUsername == null) ? 0 : adminUsername.hashCode());
		result = prime * result + ((adminPassword == null) ? 0 : adminPassword.hashCode());
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
		AdminEntity other = (AdminEntity) obj;
		if (adminId != other.adminId)
			return false;
		if (adminUsername == null) {
			if (other.adminUsername != null)
				return false;
		} else if (!adminUsername.equals(other.adminUsername))
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("AdminEntity [adminId=%s, adminUsername=%s, adminPassword=%s]", adminId, adminUsername,
				adminPassword);
	}

}
