package com.cg.ndp.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmployeeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int employeeId;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be omitted")
	private String employeeName;

	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "gmail dhould follow the format any@any.any")
	@NotNull(message = "email number cannot be omitted")
	private String email;

	@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits and should not start with 0")
	@NotNull(message = "Mobile number cannot be omitted")
	private String phone;

	@NotEmpty(message = "username cannot be empty")
	@NotNull(message = "username cannot be omitted")
	private String username;

	@JsonIgnore
	@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required")
	private String password;

	@NotEmpty(message = "Address Id cannot be empty")
	@NotNull(message = "Address Id cannot be omitted")
	private AddressModel address;

	public EmployeeModel() {

		/* default constructor */
	}

	public EmployeeModel(int employeeId,
			@NotEmpty(message = "name cannot be empty") @NotNull(message = "name cannot be omitted") String employeeName,
			@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "gmail dhould follow the format any@any.any") @NotNull(message = "email number cannot be omitted") String email,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits and should not start with 0") @NotNull(message = "Mobile number cannot be omitted") String phone,
			@NotEmpty(message = "username cannot be empty") @NotNull(message = "username cannot be omitted") String username,
			@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required") String password,
			@NotEmpty(message = "Address Id cannot be empty") @NotNull(message = "Address Id cannot be omitted") AddressModel address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		EmployeeModel other = (EmployeeModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeModel [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", phone=" + phone + ", username=" + username + ", password=" + password + ", address=" + address
				+ "]";
	}

}