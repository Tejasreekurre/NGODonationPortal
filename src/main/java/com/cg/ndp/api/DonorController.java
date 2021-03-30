package com.cg.ndp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ndp.exception.DuplicateDonorException;
import com.cg.ndp.exception.NoSuchDonorException;
import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.service.IDonorService;

@RestController
@RequestMapping("/donors")
@CrossOrigin
public class DonorController {

	@Autowired
	private IDonorService donorService;

	@GetMapping("/{donorId}")
	public ResponseEntity<DonorModel> getById(@PathVariable("donorId") int donorId) throws NoSuchDonorException {
		return ResponseEntity.ok(donorService.getById(donorId));

	}

	@PostMapping("/adddonor")
	public ResponseEntity<String> RegisterDonor(@RequestBody DonorModel donor) throws DuplicateDonorException {
		ResponseEntity<String> response = null;
		if (donor == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			donor = donorService.add(donor);
			// user=userService.add(user);
			response = new ResponseEntity<>("Donor is successfully added", HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping("/{donorId}/alldonations")
	public ResponseEntity<List<DonationModel>> getAllDonations(@PathVariable("donorId") int donorId)
			throws NoSuchDonorException {
		return ResponseEntity.ok(donorService.getAllDonations(donorId));
	}

	@PutMapping("/{donorId}/modifydonor")
	public ResponseEntity<String> updateDonor(@RequestBody DonorModel donor, @PathVariable("donorId") int donorId)
			throws NoSuchDonorException {
		donor = donorService.modifyPassword(donor, donor.getDonorId());

		return new ResponseEntity<>("Password was Resetted Successfully", HttpStatus.OK);

	}

	@PostMapping("/{donorId}/modifydonor/emailpasswordtodonor")
	public ResponseEntity<String> sendThankYouMail(@RequestBody DonorModel donorModel) {
		ResponseEntity<String> response = null;
		if (donorModel != null) {
			response = new ResponseEntity<>("Email Password Mail was Sent to Id " + donorModel.getDonorId(),
					HttpStatus.OK);
		}

		return response;
	}

}