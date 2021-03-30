package com.cg.ndp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Embeddable
public class AddressModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int addressId;

	@NotNull(message = "city cannot be null")
	@NotBlank(message = "city cannot be blank")
	private String city;

	@NotNull(message = "state cannot be null")
	@NotBlank(message = "state cannot be blank")
	private String state;

	@NotNull(message = "pin cannot be null")
	@NotBlank(message = "pin cannot be blank")
	private String pincode;

	@NotNull(message = "landmark cannot be null")
	@NotBlank(message = "landmark cannot be blank")
	private String landmark;

	public AddressModel() {
		// default constructor
	}

	public AddressModel(int addressId,
			@NotNull(message = "city cannot be null") @NotBlank(message = "city cannot be blank") String city,
			@NotNull(message = "state cannot be null") @NotBlank(message = "state cannot be blank") String state,
			@NotNull(message = "pin cannot be null") @NotBlank(message = "pin cannot be blank") String pincode,
			@NotNull(message = "landmark cannot be null") @NotBlank(message = "landmark cannot be blank") String landmark) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.landmark = landmark;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((landmark == null) ? 0 : landmark.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		AddressModel other = (AddressModel) obj;
		if (addressId != other.addressId)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (landmark == null) {
			if (other.landmark != null)
				return false;
		} else if (!landmark.equals(other.landmark))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("AddressModel [addressId=%s, city=%s, state=%s, pin=%s, landmark=%s]", addressId, city,
				state, pincode, landmark);
	}

}