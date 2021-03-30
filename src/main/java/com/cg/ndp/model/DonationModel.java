package com.cg.ndp.model;

import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.io.Serializable;
import java.time.LocalDate;

public class DonationModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int donationId;

	@NotEmpty(message = " Donor Id cannot be empty")
	@NotNull(message = " Donor Id cannot be omitted")
	private int donorId;

	@NotEmpty(message = " Item Id cannot be empty")
	@NotNull(message = " Item Id cannot be omitted")
	private int itemId;

	@NotEmpty(message = " DonationAmount cannot be empty")
	@NotNull(message = " DonationAmount cannot be omitted")
	private double donationAmount;

	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "donation date cannot be in future")
	private LocalDate donationDate;

	@NotEmpty(message = " Donation Type cannot be empty")
	@NotNull(message = " Donation Type cannot be omitted")
	private String donationType;

	public DonationModel() {
		// default constructor
	}

	public DonationModel(int donationId,
			@NotEmpty(message = " Donor Id cannot be empty") @NotNull(message = " Donor Id cannot be omitted") int donorId,
			@NotEmpty(message = " Item Id cannot be empty") @NotNull(message = " Item Id cannot be omitted") int itemId,
			@NotEmpty(message = " DonationAmount cannot be empty") @NotNull(message = " DonationAmount cannot be omitted") double donationAmount,
			@PastOrPresent(message = "donation date cannot be in future") LocalDate donationDate,
			@NotEmpty(message = " Donation Type cannot be empty") @NotNull(message = " Donation Type cannot be omitted") String donationType) {
		super();
		this.donationId = donationId;
		this.donorId = donorId;
		this.itemId = itemId;
		this.donationAmount = donationAmount;
		this.donationDate = donationDate;
		this.donationType = donationType;
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public LocalDate getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(donationAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((donationDate == null) ? 0 : donationDate.hashCode());
		result = prime * result + donationId;
		result = prime * result + ((donationType == null) ? 0 : donationType.hashCode());
		result = prime * result + donorId;
		result = prime * result + itemId;
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
		DonationModel other = (DonationModel) obj;
		if (Double.doubleToLongBits(donationAmount) != Double.doubleToLongBits(other.donationAmount))
			return false;
		if (donationDate == null) {
			if (other.donationDate != null)
				return false;
		} else if (!donationDate.equals(other.donationDate))
			return false;
		if (donationId != other.donationId)
			return false;
		if (donationType == null) {
			if (other.donationType != null)
				return false;
		} else if (!donationType.equals(other.donationType))
			return false;
		if (donorId != other.donorId)
			return false;
		if (itemId != other.itemId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonationModel [donationId=" + donationId + ", donorId=" + donorId + ", itemId=" + itemId
				+ ", donationAmount=" + donationAmount + ", donationDate=" + donationDate + ", donationType="
				+ donationType + "]";
	}

}