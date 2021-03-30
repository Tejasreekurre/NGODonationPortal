package com.cg.ndp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="needyrequest")
public class NeedyRequest {
	@Id
	@Column(name = "needyPersonId")
	private int needyPersonId;

	@Column(name = "needyPersonName")
	private String needyPersonName;

	@Column(name = "phone")
	private String phone;
	
	public NeedyRequest() {
		
	}

	public NeedyRequest(int needyPersonId, String needyPersonName, String phone) {
		super();
		this.needyPersonId = needyPersonId;
		this.needyPersonName = needyPersonName;
		this.phone = phone;
	}

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public String getNeedyPersonName() {
		return needyPersonName;
	}

	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		NeedyRequest other = (NeedyRequest) obj;
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
		return String.format("NeedyRequest [needyPersonId=%s, needyPersonName=%s, phone=%s]", needyPersonId,
				needyPersonName, phone);
	}
	
}
