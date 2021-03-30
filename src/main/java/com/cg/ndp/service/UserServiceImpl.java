package com.cg.ndp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ndp.exception.UserException;
import com.cg.ndp.model.UserModel;
import com.cg.ndp.repo.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private EMParser parser;
	

	public UserServiceImpl() {
		//default constructor
	}


	public UserServiceImpl(IUserRepository userRepo) {
		super();
		this.userRepo = userRepo;
		this.parser=new EMParser();
	}
	


	public IUserRepository getUserRepo() {
		return userRepo;
	}


	public void setUserRepo(IUserRepository userRepo) {
		this.userRepo = userRepo;
	}


	public EMParser getParser() {
		return parser;
	}


	public void setParser(EMParser parser) {
		this.parser = parser;
	}


	@Override
	public UserModel signIn(UserModel user) throws UserException {
		if(userRepo.findById(user.getUserId()).orElse(null).getPassword()==user.getPassword()) {
			return user;
		} else {
			throw new UserException("Invalid password/user");
		}
		
	}


	@Override
	public UserModel findById(int userId) {
		return parser.parse(userRepo.findById(userId).orElse(null));
	}

}