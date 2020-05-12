package com.hf.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hf.bean.Emp;
import com.hf.mapper.EmpMapper;

public class TestPage {
	
	@Test
	public void testPage() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
		PageHelper.startPage(1, 1);
		List<Emp> list = mapper.getAllEmp();
		
		PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
		System.out.println(PageUtil.getPageInfo(pageInfo, null));
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}	
