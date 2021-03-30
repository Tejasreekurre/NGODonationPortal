package com.cg.ndp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donationdistributions")
public class DonationDistributionEntity {

	@Id
	@Column(name = "distributionId", nullable = false)
	private int distributionId;

	@Column(name = "amountDistributed", nullable = false)
	private double amountDistributed;

	@Column(name = "dateOfDistribution", nullable = false)
	private LocalDate dateOfDistribution;

	@Column(name = "approvalOrRejectedDate", nullable = false)
	private LocalDate approvalOrRejectedDate;

	@Column(name = "status", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private DonationDistributionStatus status;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "needyPersonId")
	private NeedyPeopleEntity person;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId")
	private EmployeeEntity distributedBy;
	
	@OneToOne
	private DonationItemEntity item;

	public DonationDistributionEntity() {
		super();
	}

	public DonationDistributionEntity(int distributionId, double amountDistributed, LocalDate dateOfDistribution,
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
		return "DonationDistributionEntity [distributionId=" + distributionId + ", amountDistributed="
				+ amountDistributed + ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate="
				+ approvalOrRejectedDate + ", status=" + status + ", person=" + person + ", distributedBy="
				+ distributedBy + ", item=" + item + "]";
	}

}
