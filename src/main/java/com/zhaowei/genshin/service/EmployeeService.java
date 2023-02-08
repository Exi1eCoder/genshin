package com.zhaowei.genshin.service;

import java.util.List;

import com.zhaowei.genshin.pojo.Employee;

public interface EmployeeService {
	/**
	 * 查询所有的而员工信息
	 * @return
	 */
	List<Employee> getAllEmployee();
	/**
	 * 根据用户id查询持有角色信息
	 */
	List<Employee> getHoldEmployeeByUid(Integer uid);
}
