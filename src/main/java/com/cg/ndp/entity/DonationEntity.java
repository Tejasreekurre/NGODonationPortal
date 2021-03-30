package com.cg.ndp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "donations")
public class DonationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "donation_id")
	private int donationId;

	@ManyToOne
	@JoinColumn(name = "donor_id")
	private DonorEntity donor;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private DonationItemEntity itemz;

	@Column(name = "donation_amount")
	private double donationAmount;

	@Column(name = "date_of_donation")
	private LocalDate donationDate;

	@Column(name = "donation_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private DonationType donationType;;

	public DonationEntity() {
		// default constructor
	}

	public DonationEntity(int donationId, DonorEntity donor, DonationItemEntity itemz, double donationAmount,
			LocalDate donationDate, DonationType donationType) {
		super();
		this.donationId = donationId;
		this.donor = donor;
		this.itemz = itemz;
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

	public DonorEntity getDonor() {
		return donor;
	}

	public void setDonor(DonorEntity donor) {
		this.donor = donor;
	}

	public DonationItemEntity getItemz() {
		return itemz;
	}

	public void setItemz(DonationItemEntity itemz) {
		this.itemz = itemz;
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

	public DonationType getDonationType() {
		return donationType;
	}

	public void setDonationType(DonationType donationType) {
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
		result = prime * result + ((donor == null) ? 0 : donor.hashCode());
		result = prime * result + ((itemz == null) ? 0 : itemz.hashCode());
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
		DonationEntity other = (DonationEntity) obj;
		if (Double.doubleToLongBits(donationAmount) != Double.doubleToLongBits(other.donationAmount))
			return false;
		if (donationDate == null) {
			if (other.donationDate != null)
				return false;
		} else if (!donationDate.equals(other.donationDate))
			return false;
		if (donationId != other.donationId)
			return false;
		if (donationType != other.donationType)
			return false;
		if (donor == null) {
			if (other.donor != null)
				return false;
		} else if (!donor.equals(other.donor))
			return false;
		if (itemz == null) {
			if (other.itemz != null)
				return false;
		} else if (!itemz.equals(other.itemz))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonationEntity [donationId=" + donationId + ", donor=" + donor + ", itemz=" + itemz
				+ ", donationAmount=" + donationAmount + ", donationDate=" + donationDate + ", donationType="
				+ donationType + "]";
	}

}