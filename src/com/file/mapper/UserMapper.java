package com.file.mapper;

import com.file.annotation.DocAnnotation;
import com.file.vo.User;
@DocAnnotation
public interface UserMapper {
	
	boolean addUserByUser(User user);
	
	String getUserNameByUserId(int user_id);

	User getUserByUser(User user);
}
