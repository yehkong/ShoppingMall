package com.taotao.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.content.service.ContentCategoryService;

@Controller
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService service;
	
	@RequestMapping(value = "/content/category/list",method = RequestMethod.GET)
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value="id",defaultValue="0") Long parentId){
		//1. 引入服务
		//2. 注入服务
		//3. 调用服务
		return service.getContentCategoryList(parentId);
	}
}
