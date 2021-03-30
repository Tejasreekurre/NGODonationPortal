package com.cg.ndp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ndp.entity.AdminEntity;
import com.cg.ndp.entity.DonationDistributionEntity;
import com.cg.ndp.entity.DonationDistributionStatus;
import com.cg.ndp.entity.EmployeeEntity;
import com.cg.ndp.exception.DuplicateAdminException;
import com.cg.ndp.exception.DuplicateDonationException;
import com.cg.ndp.exception.DuplicateEmployeeException;
import com.cg.ndp.exception.NoSuchAdminException;
import com.cg.ndp.exception.NoSuchDonationException;
import com.cg.ndp.exception.NoSuchEmployeeException;
import com.cg.ndp.model.AdminModel;
import com.cg.ndp.model.DonationDistributionModel;
import com.cg.ndp.model.EmployeeModel;
import com.cg.ndp.repo.AdminRepo;
import com.cg.ndp.repo.DonationDistributionRepo;
import com.cg.ndp.repo.EmployeeRepo;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private DonationDistributionRepo donationRepo;

	@Autowired
	private EMParser parser;

	public AdminServiceImpl() {

	}

	public AdminServiceImpl(AdminRepo adminRepo, EMParser parser, EmployeeRepo empRepo, DonationDistributionRepo donationRepo) {
		super();
		this.adminRepo = adminRepo;
		this.empRepo = empRepo;
		this.donationRepo = donationRepo;
		this.parser = new EMParser();
	}

	public AdminRepo getAdminRepo() {
		return adminRepo;
	}

	public void setAdminRepo(AdminRepo adminRepo) {
		this.adminRepo = adminRepo;
	}

	public EMParser getParser() {
		return parser;
	}

	public void setParser(EMParser parser) {
		this.parser = parser;
	}

	public EmployeeRepo getEmpRepo() {
		return empRepo;
	}

	public void setEmpRepo(EmployeeRepo empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	public boolean addEmployee(EmployeeModel employee) throws DuplicateEmployeeException {
		Boolean status = false;
		if (employee != null) {
			if (empRepo.existsById(employee.getEmployeeId())) {
				throw new DuplicateEmployeeException("Already Exists");
			}
			employee = parser.parse(empRepo.save(parser.parse(employee)));
			status = true;

		}
		return status;
	}

	@Transactional
	@Override
	public EmployeeModel modifyEmployee(EmployeeModel employee) throws NoSuchEmployeeException {
		
		if (employee != null) {
			if (!empRepo.existsById(employee.getEmployeeId())) {
				throw new NoSuchEmployeeException("No Such Employee");
			}

			employee = parser.parse(empRepo.saveAndFlush(parser.parse(employee)));
		}

		return employee;
	}
	
	@Override
	public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException {
		Boolean status = false;
		if (empRepo.existsById(employeeId)) {
			empRepo.deleteById(employeeId);
			status = true;
		} else {
			throw new NoSuchEmployeeException("Person does not Exists");
		}

		return status;
	}

	@Override
	public EmployeeModel findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		if (!empRepo.existsById(employeeId)) {
			throw new NoSuchEmployeeException("Person does not Exists");
		}
		return parser.parse(empRepo.findById(employeeId).orElse(null));
	}

	@Override
	public List<EmployeeModel> findEmployeeByName(String name) throws NoSuchEmployeeException {
		EmployeeEntity employee = empRepo.findByEmployeeName(name).orElse(null);

		if (employee == null) {
			throw new NoSuchEmployeeException("No Such people");
		}

		return employee.getAllEmployees.stream().map(parser::parse).collect(Collectors.toList());

	}

	@Override
	public List<EmployeeModel> findAllEmployee() throws NoSuchEmployeeException {
		return empRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public boolean approveDonation(DonationDistributionModel distribution)
			throws DuplicateDonationException, NoSuchDonationException {
		Boolean status = false;
		DonationDistributionEntity dt = donationRepo.findById(distribution.getDistributionId()).get();
		if (dt != null) {
			if (dt.getStatus() != DonationDistributionStatus.APPROVED) {
				distribution.setStatus(DonationDistributionStatus.APPROVED);
				distribution = parser.parse(donationRepo.save(parser.parse(distribution)));
				status = true;

			} else {
				throw new DuplicateDonationException("Already Approved");
			}
		} else {
			throw new NoSuchDonationException("No Such donation id Found");
		}

		return status;
	}

	@Override
	public boolean addAdmin(AdminModel admin) throws DuplicateAdminException {
		Boolean status = false;
		if (admin != null) {
			if (empRepo.existsById(admin.getAdminId())) {
				throw new DuplicateAdminException("Already Exists");
			}
			admin = parser.parse(adminRepo.save(parser.parse(admin)));
			status = true;

		}
		return status;
	}

	@Override
	public boolean login(AdminModel admin) throws NoSuchAdminException {
		boolean status = false;
		Optional<AdminEntity> ad=adminRepo.findById(admin.getAdminId());
		if(ad.isPresent()) {
			if (ad.get().getAdminpassword().equals(admin.getAdminPassword())) {
				status = true;
			}
		} else {
			throw new NoSuchAdminException("Invalid username/ password");
		}
		return status;
	}

}