package com.zhaowei.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaowei.genshin.mapper.UserMapper;
import com.zhaowei.genshin.pojo.User;
import com.zhaowei.genshin.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(String uname, String pwd) {
		return userMapper.getUserByNamePwd(uname, pwd);
	}

}
