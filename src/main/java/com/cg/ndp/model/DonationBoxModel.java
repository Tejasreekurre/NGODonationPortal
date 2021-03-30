package com.cg.ndp.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DonationBoxModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "ngoName cannot be empty")
	@NotNull(message = "ngoName cannot be omitted")
	private String ngoName;

	@Pattern(regexp = "[1-9][0-9]{2}", message = "Registration number is expected to be 3 digits and should not start with 0")
	@NotNull(message = "Registration number cannot be omitted")
	private String registrationNumber;

	@Pattern(regexp = "[1-9]{10}", message = "Account number is expected to be 10 digits and should not start with 0")
	@NotNull(message = "Account number cannot be omitted")
	private String accountNumber;

	private double totalCollection;

	public DonationBoxModel() {
		/* default constructors */

	}

	public DonationBoxModel(
			@NotEmpty(message = "ngoName cannot be empty") @NotNull(message = "ngoName cannot be omitted") String ngoName,
			@Pattern(regexp = "[1-9][0-9]{2}", message = "Registration number is expected to be 3 digits and should not start with 0") @NotNull(message = "Registration number cannot be omitted") String registrationNumber,
			@Pattern(regexp = "[1-9]{10}", message = "Account number is expected to be 10 digits and should not start with 0") @NotNull(message = "Account number cannot be omitted") String accountNumber,
			double totalCollection) {
		super();
		this.ngoName = ngoName;
		this.registrationNumber = registrationNumber;
		this.accountNumber = accountNumber;
		this.totalCollection = totalCollection;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(double totalCollection) {
		this.totalCollection = totalCollection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((ngoName == null) ? 0 : ngoName.hashCode());
		result = prime * result + ((registrationNumber == null) ? 0 : registrationNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCollection);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		DonationBoxModel other = (DonationBoxModel) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (ngoName == null) {
			if (other.ngoName != null)
				return false;
		} else if (!ngoName.equals(other.ngoName))
			return false;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		if (Double.doubleToLongBits(totalCollection) != Double.doubleToLongBits(other.totalCollection))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonationBox [ngoName=" + ngoName + ", registrationNumber=" + registrationNumber + ", accountNumber="
				+ accountNumber + ", totalCollection=" + totalCollection + "]";
	}

}