package com.taotao.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.service.ItemCatService;
import com.taotao.pojo.TbItemCat;

@Service
public class ItemCatServiceImpl implements ItemCatService{


	@Autowired
	private ItemCatMapper itemCatMapper;
	
	@Override
	public List<TbItemCat> queryItemCatByPage(Map param) {
		
		
		return this.itemCatMapper.queryItemCatByPage(param);
	}

}
