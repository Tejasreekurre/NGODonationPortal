package com.cg.ndp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ndp.exception.DuplicateAdminException;
import com.cg.ndp.exception.DuplicateDonationException;
import com.cg.ndp.exception.DuplicateEmployeeException;
import com.cg.ndp.exception.NoSuchAdminException;
import com.cg.ndp.exception.NoSuchDonationException;
import com.cg.ndp.exception.NoSuchEmployeeException;
import com.cg.ndp.model.AdminModel;
import com.cg.ndp.model.DonationDistributionModel;
import com.cg.ndp.model.EmployeeModel;
import com.cg.ndp.service.IAdminService;

@RestController
@RequestMapping("/ngoemployees")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/addadmin")
	public ResponseEntity<Boolean> addAdmin(@RequestBody AdminModel admin) throws  DuplicateAdminException {		
		return new ResponseEntity<Boolean>(adminService.addAdmin(admin),HttpStatus.OK);
	}
	@GetMapping("/findemployee/{id}")
	public ResponseEntity<EmployeeModel> findEmployeeById(@PathVariable Integer id) throws NoSuchEmployeeException {
		return new ResponseEntity<EmployeeModel>(adminService.findEmployeeById(id), HttpStatus.OK);
	}

	@PostMapping("/addemployee")
	public ResponseEntity<Boolean> addEmployee(@RequestBody EmployeeModel person) throws  DuplicateEmployeeException {		
		return new ResponseEntity<Boolean>(adminService.addEmployee(person),HttpStatus.OK);
	}
	

	@DeleteMapping("/removeemployee/{id}")
	public ResponseEntity<Boolean> removeEmployee(@PathVariable Integer id) throws NoSuchEmployeeException {
		return new ResponseEntity<Boolean>(adminService.removeEmployee(id), HttpStatus.OK);
	}

	@PostMapping("/modifyemployee")
	public  ResponseEntity<EmployeeModel> modifyEmployee(@RequestBody EmployeeModel employee) throws  NoSuchEmployeeException {		
		return new ResponseEntity<EmployeeModel>(adminService.modifyEmployee(employee),HttpStatus.OK);
	}
	@GetMapping("/findallemployees")
	public ResponseEntity<List<EmployeeModel>> findAllEmployees() throws NoSuchEmployeeException {
		return new ResponseEntity<List<EmployeeModel>>(adminService.findAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/findemployeebyname/{name}")
	public ResponseEntity<List<EmployeeModel>> findEmployeeByName(@PathVariable String name)
			throws NoSuchEmployeeException {
		return new ResponseEntity<List<EmployeeModel>>(adminService.findEmployeeByName(name), HttpStatus.OK);
	}

	
	@PostMapping("/adminlogin")
	public ResponseEntity<Boolean> login(@RequestBody AdminModel admin) throws NoSuchAdminException {
		return new ResponseEntity<Boolean>(adminService.login(admin), HttpStatus.OK);
	}
	@PostMapping("/approvedonation")
	public ResponseEntity<Boolean> approveDonation(@RequestBody DonationDistributionModel distribution) throws DuplicateDonationException, NoSuchDonationException {		
		return new ResponseEntity<Boolean>(adminService.approveDonation(distribution),HttpStatus.OK);
	}


}
