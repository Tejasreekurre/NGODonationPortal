package com.cg.ndp.service;


import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;

public interface IDonationService {
	DonationModel add(DonationModel donationModel);
	void  sendThankYouMailToDonator(DonorModel donorModel) ;
}
