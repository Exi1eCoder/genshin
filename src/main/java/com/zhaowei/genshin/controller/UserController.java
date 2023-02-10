package com.zhaowei.genshin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String login(String loginUser, String loginPwd, HttpSession session, HttpServletRequest request) {
		User user = userService.login(loginUser, loginPwd);
		session.setAttribute("currUser", user);
		if(user != null) {
			queryEmployee(request, user);
			return "employee_list";
		}
		return "index";
	}

	@RequestMapping("/userAddEmployee")
	public String userAddEmployee() {
		return "user_add";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String attribute = request.getParameter("attribute");
		String country = request.getParameter("country");
		String profile = request.getParameter("profile");
		User user = (User) session.getAttribute("currUser");
		employeeService.saveEmp(new Employee(0, name, gender, attribute, country, profile, 0));
		queryEmployee(request, user);
		return "employee_list";
	}
	
	public void queryEmployee(HttpServletRequest request, User user) {
		List<Employee> list = employeeService.getAllEmployee();
		//当前用户持有的角色
		List<Employee> holdList = employeeService.getHoldEmployeeByUid(user.getId());
		request.setAttribute("list", list);
		request.setAttribute("holdList", holdList);
	}
	
}
