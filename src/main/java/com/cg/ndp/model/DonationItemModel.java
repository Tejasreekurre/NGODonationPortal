package com.cg.ndp.model;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DonationItemModel implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	private int itemId;
	
	@NotEmpty(message="	Donation Type cannot be empty")
	@NotNull(message=" Donation Type cannot be omitted")
	private String item;
	
	@NotEmpty(message=" Item Description cannot be empty")
	@NotNull(message=" Item Description cannot be omitted")
	private String itemDescription;


	public DonationItemModel() {
		// default Constructor
	}


	public DonationItemModel(int itemId,
			@NotEmpty(message = "\tDonation Type cannot be empty") @NotNull(message = " Donation Type cannot be omitted") String item,
			@NotEmpty(message = " Item Description cannot be empty") @NotNull(message = " Item Description cannot be omitted") String itemDescription) {
		super();
		this.itemId = itemId;
		this.item = item;
		this.itemDescription = itemDescription;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
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
		DonationItemModel other = (DonationItemModel) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemId != other.itemId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format("DonationItem [itemId=%s, item=%s, itemDescription=%s]", itemId, item, itemDescription);
	}




}
