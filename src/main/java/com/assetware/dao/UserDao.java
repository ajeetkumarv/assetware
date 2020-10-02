package com.assetware.dao;

import java.util.List;

import com.assetware.beans.User;
import com.assetware.exception.UserDetailExistException;

public interface UserDao {

	public void create(User user) throws UserDetailExistException;
	public List<User> search();
	
}
