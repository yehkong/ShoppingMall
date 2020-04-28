package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	public List<EasyUITreeNode> getContentCategoryList(Long parentID);
	
	public TaotaoResult addContentCategory(Long parentId, String name);
	
	public TaotaoResult renameCategory(Long nodeId, String name);
	
	public TaotaoResult deleteCategory(Long id);
}
