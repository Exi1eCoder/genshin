package com.zhaowei.genshin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhaowei.genshin.pojo.Item;
import com.zhaowei.genshin.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String getAllItem(Model model) {
		//查询所有的物品信息
		List<Item> list = itemService.getAllItem();
		model.addAttribute("list", list);
		return "item_list";
	}
}
