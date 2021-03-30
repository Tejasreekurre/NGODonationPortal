package com.cg.ndp.dto;

public class RequestForHelpDto {
	private String requestForHelp;
	private int needyPersonId;
	public RequestForHelpDto() {
	
	}
	public RequestForHelpDto(int needyPersonId, String requestForHelp) {
		super();
		this.requestForHelp = requestForHelp;
		this.needyPersonId = needyPersonId;
	}
	public String getRequestForHelp() {
		return requestForHelp;
	}
	public void setRequestForHelp(String requestForHelp) {
		this.requestForHelp = requestForHelp;
	}
	public int getNeedyPersonId() {
		return needyPersonId;
	}
	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + needyPersonId;
		result = prime * result + ((requestForHelp == null) ? 0 : requestForHelp.hashCode());
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
		RequestForHelpDto other = (RequestForHelpDto) obj;
		if (needyPersonId != other.needyPersonId)
			return false;
		if (requestForHelp == null) {
			if (other.requestForHelp != null)
				return false;
		} else if (!requestForHelp.equals(other.requestForHelp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("RequestForHelpDto [requestForHelp=%s, needyPersonId=%s]", requestForHelp, needyPersonId);
	}
	
	

}