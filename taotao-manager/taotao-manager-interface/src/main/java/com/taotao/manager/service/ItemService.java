package com.taotao.manager.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService extends BaseService<TbItem> {
	public TaotaoResult saveItem(TbItem item, String desc);
}
