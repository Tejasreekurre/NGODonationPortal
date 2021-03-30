package com.cg.ndp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ndp.entity.DonorEntity;
import com.cg.ndp.exception.DuplicateDonorException;
import com.cg.ndp.exception.NoSuchDonorException;
import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.repo.DonorRepo;

@Service
public class DonorServiceImpl implements IDonorService {

	@Autowired
	private DonorRepo donorRepo;

	@Autowired
	private EMParser parser;

	public DonorServiceImpl() {
		// default constructor
	}

	public DonorServiceImpl(DonorRepo donorRepo) {
		super();
		this.donorRepo = donorRepo;
		this.parser = new EMParser();
	}

	public DonorRepo getDonorRepo() {
		return donorRepo;
	}

	public void setDonorRepo(DonorRepo donorRepo) {
		this.donorRepo = donorRepo;
	}

	public EMParser getParser() {
		return parser;
	}

	public void setParser(EMParser parser) {
		this.parser = parser;
	}


	@Override
	public DonorModel getById(int donorId) throws NoSuchDonorException {
		if (!donorRepo.existsById(donorId))
			throw new NoSuchDonorException("No such donor exists with the given Id");
		return parser.parse(donorRepo.findById(donorId).orElse(null));
	}



	@Transactional
	@Override
	public DonorModel add(DonorModel donor) throws DuplicateDonorException {
		if (donor != null) {
			if (donorRepo.existsById(donor.getDonorId())) {
				throw new DuplicateDonorException("Donor with this id already exists");
			}
			donor = parser.parse(donorRepo.save(parser.parse(donor)));

		}
		return donor;
	}

	@Override
	public List<DonationModel> getAllDonations(int donorId) throws NoSuchDonorException {
		DonorEntity donor = donorRepo.findById(donorId).orElse(null);
		if (donor == null) {
			throw new NoSuchDonorException("No such donor");
		}

		return donor.getDonations().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public boolean login(DonorModel donor) throws NoSuchDonorException {
		boolean status = false;
		if (donorRepo.findById(donor.getDonorId()).orElse(null).getDonorPassword() == donor.getDonorPassword()) {
			status = true;
		} else {
			throw new NoSuchDonorException("Invalid password / user");
		}
		return status;
	}

	@Override
	public DonorModel modifyPassword(DonorModel donorModel, int donorId) throws NoSuchDonorException {
		if (donorModel != null) {
			if (!donorRepo.existsById(donorId)) {
				throw new NoSuchDonorException("no such id");
			}
			donorModel = parser.parse(donorRepo.save(parser.parse(donorModel)));
		}
		return donorModel;
	}

	
}