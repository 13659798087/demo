package com.sinosoft.demo.services;

import javax.annotation.Resource;

import com.sinosoft.demo.dao.UserDao;
import com.sinosoft.demo.model.UserInfo;
import org.springframework.stereotype.Service;

import com.sinosoft.demo.dao.ProjectDao;

import java.util.List;

@Service
public class UserServices {
	
	@Resource
	private UserDao userDao;

	public List<UserInfo> getUsers() {
		return userDao.getUsers();
	}

	public void updatePsw(String userId, String psw) {
		userDao.updatePsw(userId,psw);
	}

}
