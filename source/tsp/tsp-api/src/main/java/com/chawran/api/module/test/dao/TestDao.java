package com.chawran.api.module.test.dao;

import org.springframework.stereotype.Repository;

import com.chawran.core.mybatis.dao.BaseDao;

@Repository
@SuppressWarnings("all")
public class TestDao extends BaseDao {

	public static final String NAMESPACE = "com.chawran.api.test.mapper.TestMapper";
	
	/**
	 * 获取当前时间
	 */
	public String getCurrentTime() throws Exception {
		return this.selectOne(NAMESPACE + "." + "getCurrentTime");
	}
	
}
