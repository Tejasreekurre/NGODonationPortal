package com.cg.ndp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserModel {

	@NotNull(message="user id cannot be null")	
	@NotBlank(message="user id cannot be blank")
	private int userId;
	
	@NotNull(message="password cannot be null")	
	@NotBlank(message="password cannot be blank")
	@Pattern(regexp="(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required")
	private String password;

	@NotNull(message="Role cannot be null")	
	@NotBlank(message="Role cannot be blank")
	
	private String role;
	
	public UserModel() {
		/* Default Constructor*/
	}

	public UserModel(
			@NotNull(message = "user id cannot be null") @NotBlank(message = "user id cannot be blank") int userId,
			@NotNull(message = "password cannot be null") @NotBlank(message = "password cannot be blank") @Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required") String password,
			@NotNull(message = "Role cannot be null") @NotBlank(message = "Role cannot be blank") String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userId;
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
		UserModel other = (UserModel) obj;
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
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("UserModel [userId=%s, password=%s, role=%s]", userId, password, role);
	}

	

}