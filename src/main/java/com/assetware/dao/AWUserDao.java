package com.assetware.dao;

import com.assetware.beans.AWUser;
import com.assetware.exception.UserDetailExistException;

public interface AWUserDao {

	public void create(AWUser user) throws UserDetailExistException;
	public AWUser login(String username, String password);
	public int changePassword(String username, String newPassword);
}
