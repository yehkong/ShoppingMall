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
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService service;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value="id",defaultValue="0") Long parentId){
		//1. 引入服务
		//2. 注入服务
		//3. 调用服务
		return service.getContentCategoryList(parentId);
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createCategory(Long parentId, String name) {
		return service.addContentCategory(parentId, name);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult renameCategory(Long id, String name) {
		return service.renameCategory(id, name);
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult deleteCategory(Long id) {
		return service.deleteCategory(id);
	}
	
}
