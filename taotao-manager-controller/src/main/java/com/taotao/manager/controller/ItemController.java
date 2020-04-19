package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.manager.service.ItemService;
import com.taotao.pojo.TbItem;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(value="item/save", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult saveItem(TbItem item, String desc) {
		return this.itemService.saveItem(item, desc);
	}

}
