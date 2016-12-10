package com.file.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.file.mapper.UserMapper;
import com.file.service.UserService;
import com.file.vo.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Override
	public boolean addUserByUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName()+">>>>>>>>>"+user);
		return userMapper.addUserByUser(user);
	}

	@Override
	public String getUserNameByUserId(int user_id) {
		// TODO Auto-generated method stub
		return userMapper.getUserNameByUserId(user_id);
	}

	@Override
	public User getUserByUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUser(user);
	}

}
