package com.cqut.model.dao;

import java.util.List;

import com.cqut.pojo.UserInfo;

public interface UserDao {
	
	public UserInfo getUserInfo(String username,String password);
	public int registerUserInfo(UserInfo userinfo);
	public List<UserInfo> showAllStudents();
	public int deleteUserById(String userid);
	public UserInfo getUserById(String userid);
	public int updateUserInfo(UserInfo userinfo);
	public List<UserInfo> queryStudents(String input);
}
