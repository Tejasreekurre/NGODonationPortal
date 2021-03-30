package com.cg.ndp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ndp.exception.DuplicateNeedyPersonException;

import com.cg.ndp.exception.NoSuchNeedyException;
import com.cg.ndp.model.NeedyPeopleModel;
import com.cg.ndp.model.NeedyRequestModel;
import com.cg.ndp.service.INeedyPeopleService;
import com.cg.ndp.dto.NeedyPeopleDto;

@RestController
@RequestMapping("/needy")
public class NeedyController {

	@Autowired
	private INeedyPeopleService needyService;

	@PostMapping("/addneedypeople")
	public ResponseEntity<Boolean> registerNeedyPerson(@RequestBody NeedyPeopleModel person)
			throws DuplicateNeedyPersonException {
		return new ResponseEntity<Boolean>(needyService.registerNeedyPerson(person), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody NeedyPeopleDto person) throws NoSuchNeedyException {
		return new ResponseEntity<Boolean>(needyService.login(person), HttpStatus.OK);
	}

	@PostMapping("/needyrequest")
	public ResponseEntity<Boolean> requestForHelp(@RequestBody NeedyRequestModel person) throws DuplicateNeedyPersonException {
		return new ResponseEntity<Boolean>(needyService.requestForHelp(person), HttpStatus.OK);
	}

}