package com.chawran.core.mybatis.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * BaseDAO，所有的DAO需要继承此类
 */
@Repository
@SuppressWarnings("all")
public class BaseDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	public int insert(String statement, Object parameter) throws Exception {
		return sqlSessionTemplate.insert(statement, parameter);
	}

	public int update(String statement, Object parameter) throws Exception {
		return sqlSessionTemplate.update(statement, parameter);
	}

	public int delete(String statement, Object parameter) throws Exception {
		return sqlSessionTemplate.delete(statement, parameter);
	}
	
	public <T> T selectOne(String statement) throws Exception {
		return sqlSessionTemplate.selectOne(statement);
	}

	public <T> T selectOne(String statement, Object parameter) throws Exception {
		return sqlSessionTemplate.selectOne(statement, parameter);
	}
	
	public <E> List<E> selectList(String statement)
			throws Exception {
		return sqlSessionTemplate.selectList(statement);
	}
	
	public <E> List<E> selectList(String statement, Object parameter)
			throws Exception {
		MappedStatement ms = sqlSessionTemplate.getConfiguration().getMappedStatement(statement);
		BoundSql bs = ms.getBoundSql(parameter);
		
		return sqlSessionTemplate.selectList(statement, parameter);
	}

	public <E> List<E> selectList(String statement, Object parameter,
			int offset, int limit) throws Exception {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectList(statement, parameter, rowBounds);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey) throws Exception {
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey, int offset, int limit) throws Exception {
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey, rowBounds);
	}

}
