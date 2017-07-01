package com.cqut.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cqut.model.dao.UserDao;
import com.cqut.pojo.UserInfo;
import com.cqut.util.DBConnection;
import com.cqut.util.MD5;
import com.cqut.util.UID;

public class UserDaoImpl implements UserDao{
	private Connection conn = null;

	@Override
	public UserInfo getUserInfo(String username, String password) {
		UserInfo userinfo = null;
		conn = DBConnection.getConnection();
		String sql = "select * from t_user where username = ? and password = ?";
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,username);
			pre.setString(2,password);
			res = pre.executeQuery();
			if(res.next()){
				userinfo = new UserInfo();
				userinfo.setUserid(res.getString("userid"));
				userinfo.setUsername(res.getString("username"));
				userinfo.setPassword(res.getString("password"));
				userinfo.setRealname(res.getString("realname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userinfo;
	}

	@Override
	public int registerUserInfo(UserInfo userinfo) {
		conn = DBConnection.getConnection();
		String sql = "insert into t_user(userid,username,password,realname) values(?,?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,UID.createID());
			pre.setString(2,userinfo.getUsername());
			pre.setString(3,MD5.getMD5(userinfo.getPassword()));
			pre.setString(4,userinfo.getRealname());
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<UserInfo> showAllStudents() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfo userinfo = null;
		conn = DBConnection.getConnection();
		String sql = "select * from t_user";
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			pre = conn.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				userinfo = new UserInfo();
				userinfo.setUserid(res.getString("userid"));
				userinfo.setUsername(res.getString("username"));
				userinfo.setPassword(res.getString("password"));
				userinfo.setRealname(res.getString("realname"));
				list.add(userinfo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteUserById(String userid) {
		conn = DBConnection.getConnection();
		String sql = "delete from t_user where userid = ?";
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,userid);
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public UserInfo getUserById(String userid) {
		UserInfo userinfo = null;
		conn = DBConnection.getConnection();
		String sql = "select * from t_user where userid = ?";
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,userid);
			res = pre.executeQuery();
			if(res.next()){
				userinfo = new UserInfo();
				userinfo.setUserid(res.getString("userid"));
				userinfo.setUsername(res.getString("username"));
				userinfo.setPassword(res.getString("password"));
				userinfo.setRealname(res.getString("realname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userinfo;
	}

	@Override
	public int updateUserInfo(UserInfo userinfo) {
		conn = DBConnection.getConnection();
		String sql = "update t_user set username=?,password=?,realname=? where userid = ?";
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,userinfo.getUsername());
			pre.setString(2,userinfo.getPassword());
			pre.setString(3,userinfo.getRealname());
			pre.setString(4,userinfo.getUserid());
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<UserInfo> queryStudents(String input) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfo userinfo = null;
		conn = DBConnection.getConnection();
		String sql = "select * from t_user where realname like ? ";
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1,"%"+input+"%");
			
			res = pre.executeQuery();
			while(res.next()){
				userinfo = new UserInfo();
				userinfo.setUserid(res.getString("userid"));
				userinfo.setUsername(res.getString("username"));
				userinfo.setPassword(res.getString("password"));
				userinfo.setRealname(res.getString("realname"));
				list.add(userinfo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
