package com.dragontalker.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.dragontalker.mybatis.bean.Employee;

public class MyBatisTest {

	/**
	 * 1. 根据xml配置文件(全局配置文件), 创建一个SqlSessionFactory对象
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/**
		 * 2. 获取sqlSession实例, 能直接执行已经映射的SQL语句
		 * @param statement: Unique identifier matching the statement to use
		 * @param parameter: A parameter object to pass to the statement
		 */
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			Employee employee = 
					openSession.selectOne("com.dragontalker.batis.EmplyeeMapper.selectEmp", 1);
			
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
			
	}
}
