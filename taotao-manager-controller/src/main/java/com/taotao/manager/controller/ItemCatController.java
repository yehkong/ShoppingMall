package com.taotao.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.manager.service.ItemCatService;
import com.taotao.pojo.TbItemCat;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("query/{page}")
	@ResponseBody
	public List<TbItemCat> queryItemCatByPage(@PathVariable("page") Integer page, @RequestParam("rows") Integer rows){
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("page",page);
		map.put("rows",rows);
		List<TbItemCat> list = this.itemCatService.queryItemCatByPage(map);
		return list;
	}

}
