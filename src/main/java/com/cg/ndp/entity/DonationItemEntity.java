
package com.cg.ndp.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "donationitems")
public class DonationItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "donation_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private DonationType item;

	@Column(name = "item_description")
	private String itemDescription;

	@OneToMany(mappedBy = "itemz")
	private Set<DonationEntity> donations;

	public DonationItemEntity() {
		// default constructor
	}

	public DonationItemEntity(int itemId, DonationType item, String itemDescription) {
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

	public DonationType getItem() {
		return item;
	}

	public void setItem(DonationType item) {
		this.item = item;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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
		result = prime * result + ((donations == null) ? 0 : donations.hashCode());
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
		DonationItemEntity other = (DonationItemEntity) obj;
		if (donations == null) {
			if (other.donations != null)
				return false;
		} else if (!donations.equals(other.donations))
			return false;
		if (item != other.item)
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
		return String.format("DonationItemEntity [itemId=%s, item=%s, itemDescription=%s, donations=%s]", itemId, item,
				itemDescription, donations);
	}

}
