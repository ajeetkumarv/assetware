package com.assetware.service;

import com.assetware.beans.User;
import com.assetware.dao.UserDao;
import com.assetware.dao.impl.UserDaoImpl;
import com.assetware.exception.UserDetailExistException;

public class UserService {
	
	private UserDao userDao = new UserDaoImpl();

	private UserService() {}
	
	public void create(User user) throws UserDetailExistException {
		userDao.create(user);
	}
	
	private static class SingletonHolder {
		private static final UserService INSTANCE = new UserService();
	}
	
	public static UserService getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
