package com.zhaowei.genshin.mapper;

import java.util.List;
import java.util.Map;

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
	
	Employee getEmployeeByEid(@Param("id")Integer id);
	
	Employee getEmployeeStatusByEid(@Param("uid")Integer uid,@Param("id") Integer id);
	
	Employee getCurrEmpLevel(@Param("uid")Integer uid,@Param("eid") Integer eid);
	
	void insertSelective(Employee employee);
	
	/**
	 * 根据ID删除employee_hold表数据
	 * @param id
	 */
	void deleteEmployeeHoldById(Integer id);
	
	void insertEmployeeHoldByEid(@Param("uid")Integer uid,@Param("eid") Integer eid);
	
	/**
	 * 根据id更新employee_hold表信息
	 * @param Employee
	 * @param uid
	 */
	void updateLevelToEmpHold(Map<String, Object> map);
	
	/**
	 * 根据Uid,eid查询employee_hold表ID
	 * @param uid
	 * @param eid
	 * @return
	 */
	Integer queryEmpHoldIdByUidEid(@Param("uid")Integer uid,@Param("eid") Integer eid);
}
