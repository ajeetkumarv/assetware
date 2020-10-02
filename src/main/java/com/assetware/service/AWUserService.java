package com.assetware.service;

import com.assetware.beans.AWUser;
import com.assetware.dao.AWUserDao;
import com.assetware.dao.impl.AWUserDaoImpl;
import com.assetware.exception.UserDetailExistException;

public class AWUserService {

	private AWUserDao dao = new AWUserDaoImpl();

	public void create(AWUser awUser) {
		try {
			dao.create(awUser);
		} catch (UserDetailExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AWUser login(String username, String password) {
		return dao.login(username, password);
	}
	
	public int changePassword(String username, String newPassword) {
		return dao.changePassword(username, newPassword);
	}
	
	private AWUserService() {}
	
	private static class SingletonHolder{
        private static final AWUserService INSTANCE = new AWUserService();
    }
    
    public static AWUserService getInstance(){
        return SingletonHolder.INSTANCE;
    }
	
}
