package com.file.service;


import com.file.vo.User;
public interface UserService {

	boolean addUserByUser(User user);
	
	String getUserNameByUserId(int user_id);

	User getUserByUser(User user);

}
