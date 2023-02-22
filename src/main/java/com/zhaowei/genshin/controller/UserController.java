package com.zhaowei.genshin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	 * 登录失败则回到登录页面
	 * @param request
	 * @return
	 */
	@PostMapping("/auth")
	public String login(String loginUser, String loginPwd, HttpSession session) {
		User user = userService.login(loginUser, loginPwd);
		session.setAttribute("currUser", user);
		if(user != null) {
			//使用重定向是防止刷新重复提交表单
			//重定向并非地址，而是/employee请求
			return "redirect:/employee";
		}
		return "index";
	}

	@GetMapping("/adminAddEmployee")
	public String adminAddEmployee() {
		return "user_add";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(HttpServletRequest request) {
		employeeService.saveEmp(request);
		return "redirect:/employee";
	}
	
}
