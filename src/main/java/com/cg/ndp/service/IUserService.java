package com.cg.ndp.service;

import com.cg.ndp.exception.UserException;
import com.cg.ndp.model.UserModel;

public interface IUserService {
	UserModel signIn(UserModel user) throws UserException;
	UserModel findById(int userId);

}