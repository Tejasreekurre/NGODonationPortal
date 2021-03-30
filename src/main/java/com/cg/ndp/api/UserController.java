package com.cg.ndp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ndp.exception.NoSuchDonorException;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.model.UserModel;
import com.cg.ndp.service.IDonorService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IDonorService donorService;

	@PostMapping("/signIn")
	public ResponseEntity<String> signIn(@RequestBody UserModel user) throws NoSuchDonorException {
		ResponseEntity<String> response = null;
		@SuppressWarnings("unused")
		DonorModel donor = donorService.getById(user.getUserId());
		if (user.getPassword().equals(user.getPassword())) {
			response = new ResponseEntity<>("You Have Successfully Logged in", HttpStatus.OK);

		} else {
			response = new ResponseEntity<>("Invalid username/password", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}