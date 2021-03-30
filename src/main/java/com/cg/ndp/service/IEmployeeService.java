package com.cg.ndp.service;

import java.util.List;

import com.cg.ndp.dto.EmployeeDto;
import com.cg.ndp.exception.DuplicateDonationException;
import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchEmployeeException;
import com.cg.ndp.exception.NoSuchNeedyPeopleException;
import com.cg.ndp.model.DonationDistributionModel;
import com.cg.ndp.model.NeedyPeopleModel;

public interface IEmployeeService {

	public boolean addNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException;

	public boolean removeNeedyPerson(NeedyPeopleModel person) throws NoSuchNeedyPeopleException;

	public NeedyPeopleModel findNeedyPeopleById(int id) throws NoSuchNeedyPeopleException;

	public List<NeedyPeopleModel> findAllNeedyPeople() throws NoSuchNeedyPeopleException;

	public List<NeedyPeopleModel> findNeedyPeopleByName(String name) throws  NoSuchNeedyPeopleException;

	public String helpNeedyPerson(DonationDistributionModel distribute) throws DuplicateDonationException;

	public boolean login(EmployeeDto employee) throws NoSuchEmployeeException;


}
