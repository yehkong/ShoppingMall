package com.taotao.manager.service;

import java.util.List;
import java.util.Map;

import com.taotao.pojo.TbItemCat;

public interface ItemCatService {
	List<TbItemCat> queryItemCatByPage(Map<String, Integer> param);

}
