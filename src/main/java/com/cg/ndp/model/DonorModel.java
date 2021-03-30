package com.cg.ndp.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DonorModel  {
	
	private int donorId;
	
	@NotEmpty(message="Donor Name cannot be empty")
	@NotNull(message="Donor Name cannot be omitted")
	private String donorName;
	
	@Email(message="email must be a valid one")
	@NotNull(message="email cannot be omitted")
	private String donorEmail;
	
	@Pattern(regexp="[1-9][0-9]{9}", message="mobile number is expected to be 10 digits and should not start with 0")
	@NotNull(message="Mobile number cannot be omitted")
	private String donorPhone;
	
	@NotEmpty(message="Donor UserName cannot be empty")
	@NotNull(message="Donor UserName cannot be omitted")
	private String donorUsername;
	@JsonIgnore
	@Pattern(regexp="(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required")
	@NotNull(message="Donor Password cannot be omitted")
	private String donorPassword;
	
	@NotEmpty(message="Address  cannot be empty")
	@NotNull(message="Address cannot be omitted")
	private AddressModel address;

	
	public DonorModel() {
		//default constructor
	}


	public DonorModel(int donorId,
			@NotEmpty(message = "Donor Name cannot be empty") @NotNull(message = "Donor Name cannot be omitted") String donorName,
			@Email(message = "email must be a valid one") @NotNull(message = "email cannot be omitted") String donorEmail,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits and should not start with 0") @NotNull(message = "Mobile number cannot be omitted") String donorPhone,
			@NotEmpty(message = "Donor UserName cannot be empty") @NotNull(message = "Donor UserName cannot be omitted") String donorUsername,
			@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required") @NotNull(message = "Donor Password cannot be omitted") String donorPassword,
			@NotEmpty(message = "Address  cannot be empty") @NotNull(message = "Address cannot be omitted") AddressModel address) {
		super();
		this.donorId = donorId;
		this.donorName = donorName;
		this.donorEmail = donorEmail;
		this.donorPhone = donorPhone;
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
		this.address = address;
	}


	public int getDonorId() {
		return donorId;
	}


	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}


	public String getDonorName() {
		return donorName;
	}


	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}


	public String getDonorEmail() {
		return donorEmail;
	}


	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}


	public String getDonorPhone() {
		return donorPhone;
	}


	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}


	public String getDonorUsername() {
		return donorUsername;
	}


	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}


	public String getDonorPassword() {
		return donorPassword;
	}


	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
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
		result = prime * result + ((donorEmail == null) ? 0 : donorEmail.hashCode());
		result = prime * result + donorId;
		result = prime * result + ((donorName == null) ? 0 : donorName.hashCode());
		result = prime * result + ((donorPassword == null) ? 0 : donorPassword.hashCode());
		result = prime * result + ((donorPhone == null) ? 0 : donorPhone.hashCode());
		result = prime * result + ((donorUsername == null) ? 0 : donorUsername.hashCode());
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
		DonorModel other = (DonorModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (donorEmail == null) {
			if (other.donorEmail != null)
				return false;
		} else if (!donorEmail.equals(other.donorEmail))
			return false;
		if (donorId != other.donorId)
			return false;
		if (donorName == null) {
			if (other.donorName != null)
				return false;
		} else if (!donorName.equals(other.donorName))
			return false;
		if (donorPassword == null) {
			if (other.donorPassword != null)
				return false;
		} else if (!donorPassword.equals(other.donorPassword))
			return false;
		if (donorPhone == null) {
			if (other.donorPhone != null)
				return false;
		} else if (!donorPhone.equals(other.donorPhone))
			return false;
		if (donorUsername == null) {
			if (other.donorUsername != null)
				return false;
		} else if (!donorUsername.equals(other.donorUsername))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format(
				"DonorModel [donorId=%s, donorName=%s, donorEmail=%s, donorPhone=%s, donorUsername=%s, donorPassword=%s, address=%s]",
				donorId, donorName, donorEmail, donorPhone, donorUsername, donorPassword, address);
	}

	
	

}
