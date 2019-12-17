package cn.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	//声明SqlSessionFactory
	private static SqlSessionFactory sqlSessionFactory;
	//将连接绑定到当前线程
	private static final ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();
	//初始化
	static{
		try {
			//加载配置文件
			Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
			//创建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 返回sqlSession
	 */
	//创建连接的方法
	public static SqlSession getSqlSession(){
		//从当前线程获得sqlSession
		SqlSession sqlSession = t.get();
		//判断sqlSession的值
		if(sqlSession==null){
			//给sqlSession赋值
			sqlSession = sqlSessionFactory.openSession();
			//将sqlSession放入当前线程
			t.set(sqlSession);
		}
		return sqlSession;
	}
	/**
	 * 关闭sqlSession
	 */
	public static void close(){
		//获取sqlSession
		SqlSession sqlSession = t.get();
		//如果非空  关闭
		if(sqlSession!=null){
			sqlSession.close();
			t.remove();
		}
	}
	/**
	 * 提交事务
	 */
	public static void commit(){
		getSqlSession().commit();
		close();
	}
	/**
	 * 回滚事务
	 */
	public static void rollback(){
		getSqlSession().rollback();
		close();
	}
}
