package com.zhaowei.genshin.service;

import java.util.List;

import com.zhaowei.genshin.pojo.Item;

public interface ItemService {
	/**
	 * 查询所有物品信息
	 * @return
	 */
	List<Item> getAllItem();
	
	/**
	 * 查询当前用户持有的物品信息
	 * @param uid
	 * @return
	 */
	List<Item> getHoldItemById(Integer uid);
	
	/**
	 * 根据角色等级查询角色突破物品
	 * @param currEmp 
	 * @param empid, level
	 * @return
	 */
	List<Item> queryRequireItemByLevel(Integer id, Integer level);
	
	/**
	 * 根据天赋等级查询角色天赋突破物品
	 * @param id
	 * @param level
	 * @return
	 */
	List<Item> queryRequireSkillItemByLevel(Integer id, Integer level);
	
	/**
	 * 现有物品列表相同物品数量合并
	 * 物品总计
	 * @param totalItemList
	 * @return
	 */
	List<Item> solveTotalRequireItem(List<Item> list, List<Item> totalItemList);
}
