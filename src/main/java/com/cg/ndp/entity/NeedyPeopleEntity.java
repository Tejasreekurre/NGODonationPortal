package com.cg.ndp.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "needypeople")
public class NeedyPeopleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "needyPersonId")
	private int needyPersonId;

	@Column(name = "needyPersonName")
	private String needyPersonName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "familyIncome")
	private double familyIncome;

	@Column(name = "needyPeoplePassword")
	private String needyPeoplePassword;
	@OneToOne
	private AddressEntity address;

	@OneToMany(mappedBy = "needyPersonId")
	public Set<NeedyPeopleEntity> getAllNeedyPeople;

	public NeedyPeopleEntity() {

	}

	public NeedyPeopleEntity(int needyPersonId, String needyPersonName, String phone, double familyIncome,
			String needyPeoplePassword, AddressEntity address) {
		super();
		this.needyPersonId = needyPersonId;
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.needyPeoplePassword = needyPeoplePassword;
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public String getNeedyPersonName() {
		return needyPersonName;
	}

	public String getPhone() {
		return phone;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public Set<NeedyPeopleEntity> getGetAllNeedyPeople() {
		return getAllNeedyPeople;
	}

	public void setGetAllNeedyPeople(Set<NeedyPeopleEntity> getAllNeedyPeople) {
		this.getAllNeedyPeople = getAllNeedyPeople;
	}

	public String getNeedyPeoplePassword() {
		return needyPeoplePassword;
	}

	public void setNeedyPeoplePassword(String needyPeoplePassword) {
		this.needyPeoplePassword = needyPeoplePassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(familyIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((getAllNeedyPeople == null) ? 0 : getAllNeedyPeople.hashCode());
		result = prime * result + ((needyPeoplePassword == null) ? 0 : needyPeoplePassword.hashCode());
		result = prime * result + needyPersonId;
		result = prime * result + ((needyPersonName == null) ? 0 : needyPersonName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		NeedyPeopleEntity other = (NeedyPeopleEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(familyIncome) != Double.doubleToLongBits(other.familyIncome))
			return false;
		if (getAllNeedyPeople == null) {
			if (other.getAllNeedyPeople != null)
				return false;
		} else if (!getAllNeedyPeople.equals(other.getAllNeedyPeople))
			return false;
		if (needyPeoplePassword == null) {
			if (other.needyPeoplePassword != null)
				return false;
		} else if (!needyPeoplePassword.equals(other.needyPeoplePassword))
			return false;
		if (needyPersonId != other.needyPersonId)
			return false;
		if (needyPersonName == null) {
			if (other.needyPersonName != null)
				return false;
		} else if (!needyPersonName.equals(other.needyPersonName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NeedyPeopleEntity [needyPersonId=" + needyPersonId + ", needyPersonName=" + needyPersonName + ", phone="
				+ phone + ", familyIncome=" + familyIncome + ", needyPeoplePassword=" + needyPeoplePassword
				+ ", address=" + address + "]";
	}

}