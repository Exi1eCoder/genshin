package com.zhaowei.genshin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.pojo.User;
import com.zhaowei.genshin.service.EmployeeService;


/**
 * 
 * 
 */
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		//查询所有的员工信息
		List<Employee> list = employeeService.getAllEmployee();
		//将角色信息在请求域中共享
		model.addAttribute("list", list);
		//跳转到employee_list.html
		return "employee_list";
	}
	
	@RequestMapping(value = "/employeeDetail/{id}", method = RequestMethod.GET)
	public String getEmployeeById(HttpSession session,HttpServletRequest request,@PathVariable("id") Integer id) {
		//获得当前用户id
		User user = (User) session.getAttribute("currUser");
		Integer uid = user.getId();
		//根据角色ID查询拥有角色及状态
		Employee currEmp = employeeService.getEmployeeStatusByEid(uid, id);
		request.setAttribute("employee", currEmp);
		if(currEmp != null) {
			return "employee_detail";
		}
		currEmp = employeeService.getEmployeeByEId(id);
		request.setAttribute("employee", currEmp);
		return "employee_detail";
	}
}
