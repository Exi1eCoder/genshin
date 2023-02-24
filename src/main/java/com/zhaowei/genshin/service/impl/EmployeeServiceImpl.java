package com.zhaowei.genshin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaowei.genshin.mapper.EmployeeMapper;
import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.pojo.Item;
import com.zhaowei.genshin.service.EmployeeService;
import com.zhaowei.genshin.service.ItemService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private ItemService itemService;

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
		Integer id = employeeMapper.queryEmpHoldIdByUidEid(uid,eid);
		employeeMapper.deleteEmployeeHoldById(id);
	}

	@Override
	public void insertEmployeeHoldByEid(Integer uid, Integer eid) {
		employeeMapper.insertEmployeeHoldByEid(uid, eid);
	}

	@Override
	public Employee getCurrEmpLevel(Integer uid, Integer eid) {
		return employeeMapper.getCurrEmpLevel(uid, eid);
	}

	/**
	 * 等级更新页面所提交的等级
	 */
	@Override
	public void updateLevelToEmpHold(Employee employee, Integer uid) {
		Integer id = employeeMapper.queryEmpHoldIdByUidEid(uid, employee.getId());
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("currLevel", employee.getCurrLevel());
		map.put("tarLevel", employee.getTarLevel());
		map.put("currSkill1Level", employee.getCurrSkill1Level());
		map.put("tarSkill1Level", employee.getTarSkill1Level());
		map.put("currSkill2Level", employee.getCurrSkill2Level());
		map.put("tarSkill2Level", employee.getTarSkill2Level());
		map.put("currSkill3Level", employee.getCurrSkill3Level());
		map.put("tarSkill3Level", employee.getTarSkill3Level());
		employeeMapper.updateLevelToEmpHold(map);
	}

	/**
	 * 计算升级所需素材
	 */
	@Override
	public List<Item> calUpgradeItemReq(Employee employee) {
		List<Item> totalUpgradeItemList = new ArrayList<>();
		Integer currLevel = employee.getCurrLevel() + 1;
		Integer tarLevel = employee.getTarLevel() + 1;
		if(currLevel < tarLevel) {
			for(int i = currLevel; i < tarLevel; i++) {
				List<Item> list = new ArrayList<>();
				list = itemService.queryRequireItemByLevel(employee.getId(), i);
				itemService.solveTotalRequireItem(list, totalUpgradeItemList);
			}
		}
		return totalUpgradeItemList;
	}
	
	/**
	 * 计算技能升级所需素材
	 */
	@Override
	public List<Item> calSkillUpItemReq(Employee employee) {
		List<Item> totalList = new ArrayList<>();
		List<Item> totalSkillUpItemList = new ArrayList<>();
		Integer currSkill1Level = employee.getCurrSkill1Level();
		Integer tarSkill1Level = employee.getTarSkill1Level();
		Integer currSkill2Level = employee.getCurrSkill2Level();
		Integer tarSkill2Level = employee.getTarSkill2Level();
		Integer currSkill3Level = employee.getCurrSkill3Level();
		Integer tarSkill3Level = employee.getTarSkill3Level();
		forCalSkillUpItem(currSkill1Level, tarSkill1Level, employee, totalList);
		forCalSkillUpItem(currSkill2Level, tarSkill2Level, employee, totalList);
		forCalSkillUpItem(currSkill3Level, tarSkill3Level, employee, totalList);
		itemService.solveTotalRequireItem(totalList, totalSkillUpItemList);
		return totalSkillUpItemList;
	}
	
	private void forCalSkillUpItem(Integer currLevel, Integer tarLevel, Employee employee, List<Item> totalList)  {
		if(currLevel < tarLevel) {
			for(int i = currLevel; i < tarLevel; i++) {
				List<Item> list = new ArrayList<>();
				list = itemService.queryRequireSkillItemByLevel(employee.getId(), i);
				itemService.solveTotalRequireItem(list, totalList);
			}
		}
	}
}
