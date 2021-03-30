package com.cg.ndp.service;

import java.util.List;

import com.cg.ndp.exception.DuplicateDonorException;
import com.cg.ndp.exception.NoSuchDonorException;
import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;

public interface IDonorService {
	public boolean login(DonorModel donor) throws NoSuchDonorException;

	public DonorModel add(DonorModel donor) throws DuplicateDonorException;

	public List<DonationModel> getAllDonations(int donorId) throws NoSuchDonorException;

	public DonorModel modifyPassword(DonorModel donorModel, int donorId) throws NoSuchDonorException;

	DonorModel getById(int donorId) throws NoSuchDonorException;


}
