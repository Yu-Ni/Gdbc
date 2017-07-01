package com.cqut.model.services.impl;

import java.util.List;

import com.cqut.model.dao.UserDao;
import com.cqut.model.dao.impl.UserDaoImpl;
import com.cqut.model.services.UserService;
import com.cqut.pojo.UserInfo;
import com.cqut.util.MD5;

public class UserServiceImpl implements UserService{
	private static UserDao dao = new UserDaoImpl();
	
	@Override
	public UserInfo validate(String username, String password) {
		return dao.getUserInfo(username,MD5.getMD5(password));
	}

	@Override
	public int registerUser(UserInfo userinfo) {
		return dao.registerUserInfo(userinfo);
	}

	@Override
	public List<UserInfo> getAllStudents() {
		return dao.showAllStudents();
	}

	@Override
	public int deleteUserById(String userid) {
		return dao.deleteUserById(userid);
	}

	@Override
	public UserInfo getUserById(String userid) {
		return dao.getUserById(userid);
	}

	@Override
	public int updateUserInfo(UserInfo userinfo) {
		return dao.updateUserInfo(userinfo);
	}

	@Override
	public List<UserInfo> queryStudents(String input) {
		return dao.queryStudents(input);
	}

}
