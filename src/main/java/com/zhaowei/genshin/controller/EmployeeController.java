package com.zhaowei.genshin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhaowei.genshin.pojo.Employee;
import com.zhaowei.genshin.pojo.Item;
import com.zhaowei.genshin.pojo.User;
import com.zhaowei.genshin.service.EmployeeService;
import com.zhaowei.genshin.service.ItemService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/employee")
	public String getAllEmployee(HttpSession session, Model model) {
		User user = (User) session.getAttribute("currUser");
		//查询所有的员工信息
		//将角色信息在请求域中共享
		List<Employee> list = employeeService.getAllEmployee();
		model.addAttribute("list", list);
		if(user != null) {
			List<Employee> holdList = employeeService.getHoldEmployeeByUid(user.getId());
			model.addAttribute("holdList", holdList);
		}
		//跳转到employee_list.html
		return "employee_list";
	}
	
	@GetMapping("/employeeDetail/{id}")
	public String getEmployeeById(HttpSession session,HttpServletRequest request,@PathVariable("id") Integer id) {
		//获得当前用户id
		Integer uid = getCurrUserId(session);
		//根据角色ID查询拥有角色及状态
		Employee currEmp = employeeService.getEmployeeStatusByEid(uid, id);
		//若当前用户未持有则curEmp为空，那么直接根据eid获取角色
		if(currEmp == null) {
			currEmp = employeeService.getEmployeeByEId(id);
		}
		beforeReturnPage(request, currEmp, id);
		return "employee_detail";
	}
	
	/**
	 * 详情页面取消关注
	 */
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(HttpSession session,HttpServletRequest request,@PathVariable("id") Integer id) {
		Integer uid = getCurrUserId(session);
		employeeService.deleteEmployeeHoldByEid(uid, id);
		return "redirect:/employeeDetail/{id}";
	}
	
	/**
	 * 详情页面添加关注
	 */
	@PostMapping("/userAddEmployee/{id}")
	public String userAddEmployee(HttpSession session,HttpServletRequest request,@PathVariable("id") Integer id){
		Integer uid = getCurrUserId(session);
		employeeService.insertEmployeeHoldByEid(uid, id);
		return "redirect:/employeeDetail/{id}";
	}
	
	/**
	 * 计算角色素材消耗
	 */
	@GetMapping("/currEmpReq/{id}")
	public String userCurrEmpItemRequired(HttpSession session, HttpServletRequest request,@PathVariable("id") Integer id) {
		Integer uid = getCurrUserId(session);
		Employee employee = employeeService.getCurrEmpLevel(uid, id);
		request.setAttribute("employee", employee);
		return "employee_level";
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
		List<Item> totalSkillItemList = new ArrayList<>();
		for(int i = 1; i < 7; i++) {
			List<Item> list = new ArrayList<>();
			list = itemService.queryRequireItemByLevel(id, i);
			itemService.solveTotalRequireItem(list, totalItemList);
			request.setAttribute("listLevel" + i, list);
		}
		request.setAttribute("totalItemList", totalItemList);
		/**
		 * 查询角色天赋等级所需物品
		 * 系统设置9个等级
		 */
		for(int i = 1; i < 10; i++) {
			List<Item> list = new ArrayList<>();
			list = itemService.queryRequireSkillItemByLevel(id, i);
			itemService.solveTotalRequireItem(list, totalSkillItemList);
			request.setAttribute("listSkillLevel" + i, list);
		}
		request.setAttribute("totalSkillItemList", totalSkillItemList);
	}
	
	/**
	 * 获取当前session用户id 
	 * @param session
	 * @return
	 */
	private Integer getCurrUserId(HttpSession session) {
		User user = (User) session.getAttribute("currUser");
		return user.getId();
	}
}
