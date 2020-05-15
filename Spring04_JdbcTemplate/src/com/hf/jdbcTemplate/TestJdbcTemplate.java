package com.hf.jdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TestJdbcTemplate {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
	JdbcTemplate template = ac.getBean("jdbcTemplate", JdbcTemplate.class);

	@Test
	public void testUpdate() {
		//template.update(" insert into emp values (null,'张三',18,'男',2) ");
		/*String sql = "insert into emp values (null,?,?,?,?)";
		template.update(sql,"李四",25,"男",3);//单个增删改*/	
		/*String sql = "delete from emp where eid in (?)";*/
		/*String args = "14,15,16";
		template.update(sql, args);*/
		String eids = "14,15,16";
		String sql = "delete from emp where eid in ("+eids+")";
		template.update(sql);
		
		String mohu = "a";
		String sqls = "select * from emp where ename like '%?%'";//不能使用
		String sqlss = "select * from emp where enmae like concat ('%',?,'%',)";//可以使用
	}

	@Test
	public void testBathUpdate() throws Exception {
		String sql = "insert into emp values (null,?,?,?,?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{"a1",16,"女","1"});
		list.add(new Object[]{"a2",18,"女","2"});
		list.add(new Object[]{"a3",20,"女","3"});
		list.add(new Object[]{"a4",22,"女","4"});
		template.batchUpdate(sql, list);
	}
	
	@Test
	public void testQueryForObject(){
		//template.queryForObject(sql, requiredType)//用来获取单个值
		//template.queryForObject(sql, rowMapper, args)//用来获取单条数据
		/*String sql = "select eid,ename ,age ,sex from emp where eid =?";
		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);//将字段名(或者字段名的别名)于属性名相映射
		Emp emp = template.queryForObject(sql, new Object[]{13}, rowMapper);
		System.out.println(emp);*/
		
		String sql = "select count(*) from emp";
		Integer integer = template.queryForObject(sql, Integer.class);
		System.out.println(integer);
	}
	
	@Test
	public void testQuery(){
		String sql = "select eid,ename,age ,sex from emp";
		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);
		List<Emp> list = template.query(sql, rowMapper);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
}
