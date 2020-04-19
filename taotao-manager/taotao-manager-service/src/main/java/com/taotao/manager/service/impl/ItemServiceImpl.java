package com.taotao.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.IDUtils;
import com.taotao.manager.service.ItemDescService;
import com.taotao.manager.service.ItemService;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
@Service
public class ItemServiceImpl extends BaseServiceImpl<TbItem> implements ItemService {

	@Autowired
	private ItemDescService itemDescService;

	@Override
	public TaotaoResult saveItem(TbItem item, String desc) {
		// TODO Auto-generated method stub
		// 保存商品
		     	item.setId(IDUtils.genItemId()); 
				item.setStatus((byte) 1);
				super.saveSelective(item);

				// 保存商品描述
				TbItemDesc itemDesc = new TbItemDesc();
				itemDesc.setItemId(item.getId());
				itemDesc.setItemDesc(desc);

				this.itemDescService.saveSelective(itemDesc);
				
				return TaotaoResult.ok();

	}


}
