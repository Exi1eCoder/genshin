package com.zhaowei.genshin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.pojo.Item;

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
	
	/**
	 * 保存角色
	 * @param employee
	 */
	void saveEmp(HttpServletRequest request);
	
	/**
	 * 根据角色Id查询角色
	 * @param id
	 * @return
	 */
	Employee getEmployeeByEId(Integer id);
	
	/**
	 * 根据角色id查询当前用户此角色持有状态
	 * @param id2 
	 */
	Employee getEmployeeStatusByEid(Integer uid, Integer id);
	
	void deleteEmployeeHoldByEid(Integer uid, Integer eid);
	
	void insertEmployeeHoldByEid(Integer uid, Integer id);
	
	Employee getCurrEmpLevel(Integer uid, Integer id);
	
	void updateLevelToEmpHold(Employee employee, Integer uid);
	
	List<Item> calUpgradeItemReq(Employee employee);
	
	List<Item> calSkillUpItemReq(Employee employee);
}
