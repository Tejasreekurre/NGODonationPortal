package com.cg.ndp.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.service.IDonationService;

@RestController
@RequestMapping("/donors/{donorId}/donations")
@CrossOrigin
public class DonationController {
	@Autowired
	private IDonationService donationService;


	@PostMapping("/donatetoNGO")
	public ResponseEntity<String> donateToNgo(@RequestBody DonationModel donation){
		ResponseEntity<String>response=null;
		if(donation==null) {
			response=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			donation=donationService.add(donation);
			response = new ResponseEntity<>("THANK YOU FOR DONATING",HttpStatus.CREATED);
			
		}
		return response;
	}
	
	@PostMapping("/donatetoNGO/sendThankYouMail")
	public ResponseEntity<String> sendThankYouMail(@RequestBody DonorModel donorModel) {
		ResponseEntity<String>response = null;
		if(donorModel!= null) {
			response = new ResponseEntity<>("Thank You Email was Sent to Id "+donorModel.getDonorId(),HttpStatus.OK);
		}
		
		return response;
	}
}
