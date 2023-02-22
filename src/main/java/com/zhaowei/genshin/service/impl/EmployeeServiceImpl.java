package com.zhaowei.genshin.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaowei.genshin.mapper.EmployeeMapper;
import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.service.EmployeeService;
import com.zhaowei.genshin.utils.LevelMap;


@Service
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
	public void saveEmp(HttpServletRequest request) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String attribute = request.getParameter("attribute");
		String country = request.getParameter("country");
		String profile = request.getParameter("profile");
		Employee employee = new Employee(null,name,gender,attribute,country,profile,null,null);
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

	@Override
	public void deleteEmployeeHoldByEid(Integer uid, Integer eid) {
		employeeMapper.deleteEmployeeHoldByEid(uid, eid);
	}

	@Override
	public void insertEmployeeHoldByEid(Integer uid, Integer eid) {
		employeeMapper.insertEmployeeHoldByEid(uid, eid);
	}

	@Override
	public Employee getCurrEmpLevel(Integer uid, Integer eid) {
		Employee employee = employeeMapper.getCurrEmpLevel(uid, eid);
		employee.setCurrLevel(LevelMap.levelMap.get(employee.getCurrLevel()));
		employee.setTarLevel(LevelMap.levelMap.get(employee.getTarLevel()));
		return employee;
	}

}
