package com.zhaowei.genshin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaowei.genshin.mapper.ItemMapper;
import com.zhaowei.genshin.pojo.Item;
import com.zhaowei.genshin.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> getAllItem() {
		return itemMapper.getAllItem();
	}

}
