package com.chawran.core.mybatis.generator.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chawran.core.mybatis.generator.vo.ColumnVO;
import com.chawran.core.mybatis.generator.vo.PKColumnVO;

@SuppressWarnings("all")
public class MyBatisDao {
	
	public static final String NAMESPACE = "com.chawran.core.mybatis.generator.mapper.MyBatisMapper";
	
	private SqlSession session;
	
	public MyBatisDao() {
		try {
			String resource = "com/chawran/core/mybatis/generator/config/MyBatisConfig.xml";

			InputStream inputStream = Resources.getResourceAsStream(resource);

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			session = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取表字段信息列表
	 * @param tableSchema 数据库用户
	 * @param tableName   数据库表
	 */
	public List<ColumnVO> getColumnList(String tableSchema, String tableName) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableSchema", tableSchema);
		map.put("tableName", tableName);
		return session.selectList(NAMESPACE + "." + "getColumnList", map);
	}
	
	/**
	 * 获取表主键约束字段列表
	 * @param tableSchema 数据库用户
	 * @param tableName   数据库表
	 */
	public List<PKColumnVO> getPKColumnList(String tableSchema, String tableName) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableSchema", tableSchema);
		map.put("tableName", tableName);
		return session.selectList(NAMESPACE+ "." + "getPKColumnList", map);
	}
	
}
