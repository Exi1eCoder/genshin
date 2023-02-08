package com.zhaowei.genshin.mapper;

import org.apache.ibatis.annotations.Param;

import com.zhaowei.genshin.pojo.User;

public interface UserMapper {
	/**
	 * 根据uname,pwd查找用户
	 */
	User getUserByNamePwd(@Param("uname") String uname,@Param("password") String pwd);
}
