package com.taotao.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.manager.mapper.TestMapper;
import com.taotao.manager.service.TestService;

public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;

	@Override
	public String queryDate() {
		
		// TODO Auto-generated method stub
		return this.testMapper.queryDate();
	}

}
