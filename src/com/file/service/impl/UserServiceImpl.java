package com.file.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.file.mapper.UserMapper;
import com.file.service.UserService;
import com.file.vo.User;
import com.file.vo.UserExample;
import com.file.vo.UserExample.Criteria;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Override
	public boolean addUserByUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getSimpleName()+">>>>>>>>>"+user);
		int num = userMapper.insert(user);
		boolean res = false;
		if(num > 0) res = true;
		return res;
	}

	@Override
	public String getUserNameByUserId(int user_id) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(user_id);
		return user.getUserName();
	}

	@Override
	public User getUserByUser(User user) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(user.getUserName());
		criteria.andUserPwdEqualTo(user.getUserPwd());
		List<User> list = userMapper.selectByExample(example);
		System.out.println(list);
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

}
