package com.zhaowei.genshin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.pojo.Item;
import com.zhaowei.genshin.pojo.User;
import com.zhaowei.genshin.service.EmployeeService;
import com.zhaowei.genshin.service.ItemService;


/**
 * 
 * 
 */
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		//查询所有的员工信息
		List<Employee> list = employeeService.getAllEmployee();
		//将角色信息在请求域中共享
		model.addAttribute("list", list);
		//跳转到employee_list.html
		return "employee_list";
	}
	
//	@RequestMapping(value = "/employeeDetail/{id}", method = RequestMethod.GET)
	@GetMapping("/employeeDetail/{id}")
	public String getEmployeeById(HttpSession session,HttpServletRequest request,@PathVariable("id") Integer id) {
		//获得当前用户id
		User user = (User) session.getAttribute("currUser");
		Integer uid = user.getId();
		//根据角色ID查询拥有角色及状态
		Employee currEmp = employeeService.getEmployeeStatusByEid(uid, id);
		//若当前用户持有则curEmp不为空
		if(currEmp != null) {
			beforeReturnPage(request, currEmp, id);
			return "employee_detail";
		}
		//若用户未持有该角色
		currEmp = employeeService.getEmployeeByEId(id);
		beforeReturnPage(request, currEmp, id);
		return "employee_detail";
	}
	
	/**
	 * 跳转到角色详情页面前所需要的属性
	 * @param request
	 * @param currEmp
	 * @param id
	 */
	private void beforeReturnPage(HttpServletRequest request, Employee currEmp,Integer id) {
		request.setAttribute("employee", currEmp);
		/**
		 * 查询角色各等级突破所需物品
		 * 系统设置6个等级
		 */
		List<Item> totalItemList = new ArrayList<>();
		for(int i = 1; i < 7; i++) {
			List<Item> list = new ArrayList<>();
			list = itemService.queryRequireItemByLevel(id, i);
			itemService.solveTotalRequireItem(list, totalItemList);
			request.setAttribute("listLevel" + i, list);
		}
		request.setAttribute("totalItemList", totalItemList);
	}
}
