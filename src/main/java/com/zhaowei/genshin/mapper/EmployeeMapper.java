package com.zhaowei.genshin.mapper;

import java.util.List;

import com.zhaowei.genshin.pojo.Employee;

public interface EmployeeMapper {

	/**
	 * 查询所有的员工信息
	 * @return
	 */
	List<Employee> getAllEmployee();

}
