package com.taotao.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.service.BaseService;
import com.taotao.manager.service.ItemCatService;
import com.taotao.pojo.TbItemCat;

@Service
public class ItemCatServiceImpl extends BaseServiceImpl<TbItemCat> implements ItemCatService{

	@Override
	public List<TbItemCat> queryItemCatByParentId(Long parentId) {
		// TODO Auto-generated method stub
		TbItemCat param = new TbItemCat();
		param.setParentId(parentId);
		List<TbItemCat> queryListByWhere = super.queryListByWhere(param);
		return queryListByWhere;
	}

}
