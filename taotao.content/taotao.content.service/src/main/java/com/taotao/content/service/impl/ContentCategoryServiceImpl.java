package com.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
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

	@Override
	public TaotaoResult addContentCategory(Long parentId, String name) {
		// 1、接收两个参数：parentId、name
				// 2、向tb_content_category表中插入数据。
				// a)创建一个TbContentCategory对象
				TbContentCategory tbContentCategory = new TbContentCategory();
				// b)补全TbContentCategory对象的属性
				tbContentCategory.setIsParent(false);
				tbContentCategory.setName(name);
				tbContentCategory.setParentId(parentId);
				//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
				tbContentCategory.setSortOrder(1);
				//状态。可选值:1(正常),2(删除)
				tbContentCategory.setStatus(1);
				tbContentCategory.setCreated(new Date());
				tbContentCategory.setUpdated(new Date());
				// c)向tb_content_category表中插入数据
				mapper.insert(tbContentCategory);
				// 3、判断父节点的isparent是否为true，不是true需要改为true。
				TbContentCategory parentNode = mapper.selectByPrimaryKey(parentId);
				if (!parentNode.getIsParent()) {
					parentNode.setIsParent(true);
					//更新父节点
					mapper.updateByPrimaryKey(parentNode);
				}
				// 4、需要主键返回。
				// 5、返回TaotaoResult，其中包装TbContentCategory对象
				return TaotaoResult.ok(tbContentCategory);

	}

	@Override
	public TaotaoResult renameCategory(Long nodeId, String name) {
		TbContentCategory category = mapper.selectByPrimaryKey(nodeId);
		category.setName(name);
		mapper.updateByPrimaryKey(category);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteCategory(Long id) {
		TbContentCategory category = mapper.selectByPrimaryKey(id);
		if (category.getIsParent()) {
			return TaotaoResult.build(200, "父节点不允许删除");
		}
		mapper.deleteByPrimaryKey(id);
	    //新建example
		TbContentCategoryExample example = new TbContentCategoryExample();
		//设置条件
		example.createCriteria().andParentIdEqualTo(category.getParentId());
		//查询数量
		int countByExample = mapper.countByExample(example);
		//如果数量是0,查询父节点,更新isParent
		if (countByExample == 0) {
			TbContentCategory parentCategory = mapper.selectByPrimaryKey(category.getParentId());
			parentCategory.setIsParent(false);
			mapper.updateByPrimaryKey(parentCategory);
		}
		return null;
	}

}
