package com.taotao.manager.mapper;

import java.util.List;
import java.util.Map;

import com.taotao.pojo.TbItemCat;

public interface ItemCatMapper {
	List<TbItemCat> queryItemCatByPage(Map<String, Integer> param);
}
