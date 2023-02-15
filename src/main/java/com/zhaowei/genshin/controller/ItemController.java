package com.zhaowei.genshin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zhaowei.genshin.pojo.Item;
import com.zhaowei.genshin.pojo.User;
import com.zhaowei.genshin.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	public String getAllItem(Model model) {
		//查询所有的物品信息
		List<Item> list = itemService.getAllItem();
		model.addAttribute("list", list);
		return "item_list";
	}
	
	@GetMapping("/userHoldItem")
	public String getHoldItem(HttpSession session, Model model) {
		User user = (User) session.getAttribute("currUser");
		Integer uid = user.getId();
		List<Item> list = itemService.getHoldItemById(uid);
		model.addAttribute("list", list);
		return "hold_item";
	}
}
