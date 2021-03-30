package com.cg.ndp.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class NeedyRequestModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int needyPersonId;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be omitted")
	private String needyPersonName;

	@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits and should not start with 0")
	@NotNull(message = "Phone number cannot be omitted")
	private String phone;
	public NeedyRequestModel() {
		
	}

	public NeedyRequestModel(int needyPersonId,
			@NotEmpty(message = "name cannot be empty") @NotNull(message = "name cannot be omitted") String needyPersonName,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits and should not start with 0") @NotNull(message = "Phone number cannot be omitted") String phone) {
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
		NeedyRequestModel other = (NeedyRequestModel) obj;
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
		return String.format("NeedyRequestModel [needyPersonId=%s, needyPersonName=%s, phone=%s]", needyPersonId,
				needyPersonName, phone);
	}
	
	

}
