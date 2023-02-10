package com.zhaowei.genshin.service;

import java.util.List;

import com.zhaowei.genshin.pojo.Item;

public interface ItemService {
	/**
	 * 查询所有物品信息
	 * @return
	 */
	List<Item> getAllItem();
}
