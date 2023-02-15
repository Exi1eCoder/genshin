package com.zhaowei.genshin.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaowei.genshin.mapper.ItemMapper;
import com.zhaowei.genshin.pojo.Item;
import com.zhaowei.genshin.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> getAllItem() {
		return itemMapper.getAllItem();
	}

	@Override
	public List<Item> queryRequireItemByLevel(Integer id, Integer level) {
		return itemMapper.queryRequireItemByLevel(id, level);
	}

	@Override
	public List<Item> solveTotalRequireItem(List<Item> list, List<Item> totalItemList) {
		Map<Integer, Item> map = new HashMap<>();
		List<Item> cloneList = new ArrayList<>();
		for(Item item : list) {
			try {
				cloneList.add(item.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		if(totalItemList.isEmpty()) {
			for(Item item : cloneList) {
				map.put(item.getId(), item);
			}
			Set<Integer> set = map.keySet();
			Iterator<Integer> iterator = set.iterator();
			while(iterator.hasNext()) {
				totalItemList.add(map.get(iterator.next()));
			}
		}else {
			for(Item item : totalItemList) {
				map.put(item.getId(), item);
			}
			for(Item item : cloneList) {
				if(map.containsKey(item.getId())) {
					Item currItem = map.get(item.getId());
					Integer required = item.getRequired();
					Integer addedReq = currItem.getRequired();
					currItem.setRequired(required + addedReq);
					map.put(item.getId(), currItem);
				}
				else {
					map.put(item.getId(), item);
				}
			}
		}
		Collection<Item> values = map.values();
		totalItemList.clear();
		for(Item item : values) {
			totalItemList.add(item);
		}
		return totalItemList;
	}

	@Override
	public List<Item> getHoldItemById(Integer uid) {
		return itemMapper.getHoldItemById(uid);
	}
	
}
