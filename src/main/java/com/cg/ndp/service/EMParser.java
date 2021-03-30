package com.cg.ndp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ndp.entity.AddressEntity;
import com.cg.ndp.entity.AdminEntity;
import com.cg.ndp.entity.DonationDistributionEntity;
import com.cg.ndp.entity.DonationEntity;
import com.cg.ndp.entity.DonationItemEntity;
import com.cg.ndp.entity.DonationType;
import com.cg.ndp.entity.DonorEntity;
import com.cg.ndp.entity.EmployeeEntity;
import com.cg.ndp.entity.NeedyPeopleEntity;
import com.cg.ndp.entity.NeedyRequest;
import com.cg.ndp.entity.UserEntity;
import com.cg.ndp.model.AddressModel;
import com.cg.ndp.model.AdminModel;
import com.cg.ndp.model.DonationDistributionModel;
import com.cg.ndp.model.DonationItemModel;
import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.model.EmployeeModel;
import com.cg.ndp.model.NeedyPeopleModel;
import com.cg.ndp.model.NeedyRequestModel;
import com.cg.ndp.model.UserModel;
import com.cg.ndp.repo.DonationItemRepo;
import com.cg.ndp.repo.DonorRepo;

@Service
public class EMParser {

	@Autowired
	private DonorRepo donorRepo;

	@Autowired
	private DonationItemRepo donationItemRepo;

	public AdminEntity parse(AdminModel source) {
		return source == null ? null
				: new AdminEntity(source.getAdminId(), source.getAdminUsername(), source.getAdminPassword());
	}

	public AdminModel parse(AdminEntity source) {
		return source == null ? null
				: new AdminModel(source.getAdminId(), source.getAdminUsername(), source.getAdminpassword());
	}

	public EmployeeEntity parse(EmployeeModel source) {
		return source == null ? null
				: new EmployeeEntity(source.getEmployeeId(), source.getEmployeeName(), source.getEmail(),
						source.getPhone(), source.getUsername(), source.getPassword(), source.getAddress());

	}

	public EmployeeModel parse(EmployeeEntity source) {
		return source == null ? null
				: new EmployeeModel(source.getEmployeeId(), source.getEmployeeName(), source.getEmail(),
						source.getPhone(), source.getUsername(), source.getPassword(), source.getAddress());

	}

	public NeedyPeopleEntity parse(NeedyPeopleModel source) {
		return source == null ? null
				: new NeedyPeopleEntity(source.getNeedyPersonId(), source.getNeedyPersonName(), source.getPhone(),
						source.getFamilyIncome(), source.getNeedyPeoplePassword(),
						source.getAddress());

	}

	public NeedyPeopleModel parse(NeedyPeopleEntity source) {
		return source == null ? null
				: new NeedyPeopleModel(source.getNeedyPersonId(), source.getNeedyPersonName(), source.getPhone(),
						source.getFamilyIncome(), source.getNeedyPeoplePassword(),
						source.getAddress());
	}
	public NeedyRequest parse(NeedyRequestModel source) {
		return source == null ? null
				: new NeedyRequest(source.getNeedyPersonId(), source.getNeedyPersonName(), source.getPhone());

	}
	public NeedyRequestModel parse(NeedyRequest source) {
		return source == null ? null
				: new NeedyRequestModel(source.getNeedyPersonId(), source.getNeedyPersonName(), source.getPhone());

	}
	

	public AddressEntity parse(AddressModel source) {
		return source == null ? null
				: new AddressEntity(source.getAddressId(), source.getCity(), source.getState(), source.getPincode(),
						source.getLandmark());
	}

	public AddressModel parse(AddressEntity source) {
		return source == null ? null
				: new AddressModel(source.getAddressId(), source.getCity(), source.getState(), source.getPincode(),
						source.getLandmark());
	}

	public DonationDistributionEntity parse(DonationDistributionModel source) {
		return source == null ? null
				: new DonationDistributionEntity(source.getDistributionId(), source.getAmountDistributed(),
						source.getDateOfDistribution(), source.getApprovalOrRejectedDate(), source.getStatus(),
						source.getPerson(), source.getDistributedBy(), source.getItem());

	}

	public DonationDistributionModel parse(DonationDistributionEntity source) {
		return source == null ? null
				: new DonationDistributionModel(source.getDistributionId(), source.getAmountDistributed(),
						source.getDateOfDistribution(), source.getApprovalOrRejectedDate(), source.getStatus(),
						source.getPerson(), source.getDistributedBy(), source.getItem());
	}

	public DonationModel parse(DonationEntity source) {
		return source == null ? null
				: new DonationModel(source.getDonationId(), source.getDonor().getDonorId(),
						source.getItemz().getItemId(), source.getDonationAmount(), source.getDonationDate(),

						String.valueOf(source.getDonationType())

				);
	}

	public DonationEntity parse(DonationModel source) {
		return source == null ? null
				: new DonationEntity(source.getDonationId(), donorRepo.findById(source.getDonorId()).orElse(null),
						donationItemRepo.findById(source.getItemId()).orElse(null), source.getDonationAmount(),
						source.getDonationDate(), DonationType.valueOf(source.getDonationType()));
	}

	public DonationItemEntity parse(DonationItemModel source) {
		return source == null ? null
				: new DonationItemEntity(source.getItemId(), DonationType.valueOf(source.getItem()),
						source.getItemDescription());
	}

	public DonationItemModel parse(DonationItemEntity source) {
		return source == null ? null
				: new DonationItemModel(source.getItemId(), String.valueOf(source.getItem()),
						source.getItemDescription());
	}

	public DonorEntity parse(DonorModel source) {
		return source == null ? null
				: new DonorEntity(source.getDonorId(), source.getDonorName(), source.getDonorEmail(),
						source.getDonorPhone(), source.getDonorUsername(), source.getDonorPassword(),
						source.getAddress());
	}

	public DonorModel parse(DonorEntity source) {
		return source == null ? null
				: new DonorModel(source.getDonorId(), source.getDonorName(), source.getDonorEmail(),
						source.getDonorPhone(), source.getDonorUsername(), source.getDonorPassword(),
						source.getAddress());
	}

	public UserModel parse(UserEntity source) {
		return source == null ? null : new UserModel(source.getDonorId(), source.getPassword(), source.getRole());

	}

	public UserEntity parse(UserModel source) {
		return source == null ? null : new UserEntity(source.getUserId(), source.getPassword(), source.getRole());

	}

}
