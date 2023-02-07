package com.zhaowei.genshin.service;

import java.util.List;

import com.zhaowei.genshin.pojo.Employee;

public interface EmployeeService {
	/**
	 * 查询所有的而员工信息
	 * @return
	 */
	List<Employee> getAllEmployee();

}
