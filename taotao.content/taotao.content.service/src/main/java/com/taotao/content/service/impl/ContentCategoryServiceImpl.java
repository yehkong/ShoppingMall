package com.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.manager.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper mapper;
	
	@Override
	public List<EasyUITreeNode> getContentCategoryList(Long parentID) {
		//1. 注入mapper
		//2. 创建example
		TbContentCategoryExample exple = new TbContentCategoryExample();
		//3. 设置条件
		Criteria criteria = exple.createCriteria();
		criteria.andParentIdEqualTo(parentID);
		//4. 执行查询
		List<TbContentCategory> list = mapper.selectByExample(exple);
		//5. 转换成EasyUITreeNode
		List<EasyUITreeNode> result = new ArrayList<EasyUITreeNode>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			node.setText(tbContentCategory.getName());
			result.add(node);
		}
		// TODO Auto-generated method stub
		
				
		return result;
	}

}
