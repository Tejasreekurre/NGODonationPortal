package com.cg.ndp.service;

import java.util.List;

import com.cg.ndp.exception.DuplicateAdminException;
import com.cg.ndp.exception.DuplicateDonationException;
import com.cg.ndp.exception.DuplicateEmployeeException;
import com.cg.ndp.exception.NoSuchAdminException;
import com.cg.ndp.exception.NoSuchDonationException;
import com.cg.ndp.exception.NoSuchEmployeeException;
import com.cg.ndp.model.AdminModel;
import com.cg.ndp.model.DonationDistributionModel;
import com.cg.ndp.model.EmployeeModel;

public interface IAdminService {

	public boolean addEmployee(EmployeeModel employee) throws DuplicateEmployeeException;
	public EmployeeModel modifyEmployee(EmployeeModel employee) throws NoSuchEmployeeException;
	public boolean removeEmployee(int employee1) throws NoSuchEmployeeException;
	public EmployeeModel findEmployeeById(int employeeId) throws NoSuchEmployeeException;
	public List<EmployeeModel> findEmployeeByName(String name) throws NoSuchEmployeeException;
	public List<EmployeeModel> findAllEmployee() throws NoSuchEmployeeException;
	public boolean approveDonation(DonationDistributionModel distribution) throws DuplicateDonationException, NoSuchDonationException;

	boolean addAdmin(AdminModel admin) throws DuplicateAdminException;
	public boolean login(AdminModel admin) throws NoSuchAdminException;
	

}
