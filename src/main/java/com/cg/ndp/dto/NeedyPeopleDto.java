package com.cg.ndp.dto;

public class NeedyPeopleDto {

	private int needyPersonId;
	private String needyPeoplePassword;

	public NeedyPeopleDto() {
		super();
	}

	public NeedyPeopleDto(int needyPersonId, String needyPeoplePassword) {
		super();
		this.needyPersonId = needyPersonId;
		this.needyPeoplePassword = needyPeoplePassword;
	}

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
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
		result = prime * result + ((needyPeoplePassword == null) ? 0 : needyPeoplePassword.hashCode());
		result = prime * result + needyPersonId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof NeedyPeopleDto))
			return false;
		NeedyPeopleDto other = (NeedyPeopleDto) obj;
		if (needyPeoplePassword == null) {
			if (other.needyPeoplePassword != null)
				return false;
		} else if (!needyPeoplePassword.equals(other.needyPeoplePassword))
			return false;
		if (needyPersonId != other.needyPersonId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("NeedyPeopleDto [needyPersonId=%s, needyPeoplePassword=%s]", needyPersonId,
				needyPeoplePassword);
	}

}