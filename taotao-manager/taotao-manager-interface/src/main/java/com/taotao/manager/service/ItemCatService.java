package com.taotao.manager.service;

import java.util.List;

import com.taotao.pojo.TbItemCat;

public interface ItemCatService extends BaseService<TbItemCat> {
	//根据商品类目父id查询数据
	List<TbItemCat> queryItemCatByParentId(Long parentId);

}
