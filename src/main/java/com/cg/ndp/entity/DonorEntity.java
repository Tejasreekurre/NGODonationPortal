package com.cg.ndp.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.ndp.model.AddressModel;

@Entity
@Table(name = "donors")
public class DonorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "donor_id")
	private int donorId;

	@Column(name = "donor_name")
	private String donorName;

	@Column(name = "donor_email")
	private String donorEmail;

	@Column(name = "donor_phone")
	private String donorPhone;

	@Column(name = "donor_username")
	private String donorUsername;

	@Column(name = "donor_password")
	private String donorPassword;

	@Embedded
	private AddressModel address;

	@OneToMany(mappedBy = "donor")
	private Set<DonationEntity> donations;

	public DonorEntity() {
		// default 

	}

	public DonorEntity(int donorId, String donorName, String donorEmail, String donorPhone, String donorUsername,
			String donorPassword, AddressModel address) {
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

	public Set<DonationEntity> getDonations() {
		return donations;
	}

	public void setDonations(Set<DonationEntity> donations) {
		this.donations = donations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((donations == null) ? 0 : donations.hashCode());
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
		DonorEntity other = (DonorEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (donations == null) {
			if (other.donations != null)
				return false;
		} else if (!donations.equals(other.donations))
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
				"DonorEntity [donorId=%s, donorName=%s, donorEmail=%s, donorPhone=%s, donorUsername=%s, donorPassword=%s, address=%s, donations=%s]",
				donorId, donorName, donorEmail, donorPhone, donorUsername, donorPassword, address, donations);
	}
	

}
