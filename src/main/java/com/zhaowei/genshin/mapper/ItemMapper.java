package com.zhaowei.genshin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaowei.genshin.pojo.Item;

public interface ItemMapper {
	List<Item> getAllItem();
	
	/**
	 * 根据角色等级查询角色突破物品
	 * @param currEmp 
	 * @param empid, level
	 * @return
	 */
	List<Item> queryRequireItemByLevel(@Param("id")Integer id,@Param("level")Integer level);

	/**
	 * 根据用户uid查询所持有的物品信息
	 * @param uid
	 * @return
	 */
	List<Item> getHoldItemById(@Param("uid")Integer uid);
}
