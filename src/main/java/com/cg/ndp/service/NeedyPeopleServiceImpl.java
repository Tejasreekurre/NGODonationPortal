package com.cg.ndp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ndp.dto.NeedyPeopleDto;

import com.cg.ndp.entity.NeedyPeopleEntity;

import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchNeedyException;
import com.cg.ndp.model.NeedyPeopleModel;
import com.cg.ndp.model.NeedyRequestModel;
import com.cg.ndp.repo.NeedyPeopleRepo;
import com.cg.ndp.repo.NeedyRequestRepo;

@Service
public class NeedyPeopleServiceImpl implements INeedyPeopleService {

	@Autowired
	private NeedyPeopleRepo needyPeopleRepo;
	@Autowired
	private NeedyRequestRepo needyRequestRepo;

	@Autowired
	private EMParser parser;

	@Override
	public boolean registerNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException {
		Boolean status = false;

		if (person != null) {
			if (needyPeopleRepo.existsById(person.getNeedyPersonId())) {
				throw new DuplicateNeedyPersonException("Person already Exists");
			}
			person = parser.parse(needyPeopleRepo.save(parser.parse(person)));
			status = true;

		}

		return status;
	}

	@Override
	public boolean login(NeedyPeopleDto person) throws NoSuchNeedyException {
		boolean status = false;
		Optional<NeedyPeopleEntity> dt = needyPeopleRepo.findById(person.getNeedyPersonId());
		if (dt.isPresent()) {
			if (dt.get().getNeedyPeoplePassword().equals(person.getNeedyPeoplePassword())) {
				status = true;
			}
		} else {
			throw new NoSuchNeedyException("Invalid password / user");
		}
		return status;
	}

	@Override
	public boolean requestForHelp(NeedyRequestModel person) throws DuplicateNeedyPersonException {
		// TODO Auto-generated method stub
		Boolean status = false;

		if (person != null) {
			if (needyRequestRepo.existsById(person.getNeedyPersonId())) {
				throw new DuplicateNeedyPersonException("Person already Exists");
			}
			person = parser.parse(needyRequestRepo.save(parser.parse(person)));// ave(parser.parse(person)));
			status = true;

		}

		return status;
	}

}