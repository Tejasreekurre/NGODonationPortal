package com.cg.ndp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
	@Column(name="donor_id")
	private int donorId;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="role",nullable=false)
	private String role;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="donor_id")
	private DonorEntity user;
	
	public UserEntity() {
		//default constructor
	}

	public UserEntity(int donorId, String password, String role) {
		super();
		this.donorId = donorId;
		this.password = password;
		this.role = role;

	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + donorId;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		UserEntity other = (UserEntity) obj;
		if (donorId != other.donorId)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("User [donorId=%s, password=%s, role=%s]", donorId, password, role);
	}

	

	
}