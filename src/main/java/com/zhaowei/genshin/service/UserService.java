package com.zhaowei.genshin.service;

import com.zhaowei.genshin.pojo.User;

public interface UserService {
	User login(String uname, String pwd);
}
