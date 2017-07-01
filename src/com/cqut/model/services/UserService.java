package com.cqut.model.services;

import java.util.List;

import com.cqut.pojo.UserInfo;

public interface UserService {
	
	public UserInfo validate(String username,String password);
	public int registerUser(UserInfo userinfo);
	public List<UserInfo> getAllStudents();
	public int deleteUserById(String userid);
	public UserInfo getUserById(String userid);
	public int updateUserInfo(UserInfo userinfo);
	public List<UserInfo> queryStudents(String input);

}
