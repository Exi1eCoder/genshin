package com.zhaowei.genshin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaowei.genshin.pojo.Employee;

public interface EmployeeMapper {

	/**
	 * 查询所有的员工信息
	 * @return
	 */
	List<Employee> getAllEmployee();
	/**
	 * 根据用户id查询持有角色 
	 * @param uid
	 * @return
	 */
	List<Employee> getHoldEmployeeByUid(@Param("uid")Integer uid);

}
