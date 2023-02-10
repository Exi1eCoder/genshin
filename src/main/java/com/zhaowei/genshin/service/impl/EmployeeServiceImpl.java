package com.zhaowei.genshin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaowei.genshin.mapper.EmployeeMapper;
import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.service.EmployeeService;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeMapper.getAllEmployee() ;
	}

	@Override
	public List<Employee> getHoldEmployeeByUid(Integer uid) {
		return employeeMapper.getHoldEmployeeByUid(uid);
	}

	@Override
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	@Override
	public Employee getEmployeeByEId(Integer id) {
		return employeeMapper.getEmployeeByEid(id);
	}

	@Override
	public Employee getEmployeeStatusByEid(Integer uid, Integer id) {
		return employeeMapper.getEmployeeStatusByEid(uid, id);
	}

}
