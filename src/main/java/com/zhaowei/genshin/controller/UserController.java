package com.zhaowei.genshin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.pojo.User;
import com.zhaowei.genshin.service.EmployeeService;
import com.zhaowei.genshin.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 登录页面，验证用户登录，
	 * 登录成功，查询所有角色，
	 * 并根据employee_hold表查询已有角色
	 * 登录失败则回到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String uname = request.getParameter("loginUser");
		String pwd = request.getParameter("loginPwd");
		User user = userService.login(uname, pwd);
		if(user != null) {
			List<Employee> list = employeeService.getAllEmployee();
			//登录用户持有的角色
			List<Employee> holdList = employeeService.getHoldEmployeeByUid(user.getId());
			request.setAttribute("list", list);
			request.setAttribute("holdList", holdList);
			return "employee_list";
		}
		return "index";
	}
}
