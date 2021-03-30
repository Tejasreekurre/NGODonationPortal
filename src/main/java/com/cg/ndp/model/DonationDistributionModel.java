package com.cg.ndp.model;

import java.time.LocalDate;

import com.cg.ndp.entity.DonationDistributionStatus;
import com.cg.ndp.entity.DonationItemEntity;
import com.cg.ndp.entity.EmployeeEntity;
import com.cg.ndp.entity.NeedyPeopleEntity;

public class DonationDistributionModel {

	private int distributionId;

	private double amountDistributed;

	private LocalDate dateOfDistribution;

	private LocalDate approvalOrRejectedDate;

	private DonationDistributionStatus status;

	private NeedyPeopleEntity person;

	private EmployeeEntity distributedBy;

	private DonationItemEntity item;

	public DonationDistributionModel() {
		super();
	}

	public DonationDistributionModel(int distributionId, double amountDistributed, LocalDate dateOfDistribution,
			LocalDate approvalOrRejectedDate, DonationDistributionStatus status, NeedyPeopleEntity person,
			EmployeeEntity distributedBy, DonationItemEntity item) {
		super();
		this.distributionId = distributionId;
		this.amountDistributed = amountDistributed;
		this.dateOfDistribution = dateOfDistribution;
		this.approvalOrRejectedDate = approvalOrRejectedDate;
		this.status = status;
		this.person = person;
		this.distributedBy = distributedBy;
		this.item = item;
	}

	public int getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public double getAmountDistributed() {
		return amountDistributed;
	}

	public void setAmountDistributed(double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public LocalDate getDateOfDistribution() {
		return dateOfDistribution;
	}

	public void setDateOfDistribution(LocalDate dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public LocalDate getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public void setApprovalOrRejectedDate(LocalDate approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	public DonationDistributionStatus getStatus() {
		return status;
	}

	public void setStatus(DonationDistributionStatus status) {
		this.status = status;
	}

	public NeedyPeopleEntity getPerson() {
		return person;
	}

	public void setPerson(NeedyPeopleEntity person) {
		this.person = person;
	}

	public EmployeeEntity getDistributedBy() {
		return distributedBy;
	}

	public void setDistributedBy(EmployeeEntity distributedBy) {
		this.distributedBy = distributedBy;
	}

	public DonationItemEntity getItem() {
		return item;
	}

	public void setItem(DonationItemEntity item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "DonationDistributionModel [distributionId=" + distributionId + ", amountDistributed="
				+ amountDistributed + ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate="
				+ approvalOrRejectedDate + ", status=" + status + ", person=" + person + ", distributedBy="
				+ distributedBy + ", item=" + item + "]";
	}

}
