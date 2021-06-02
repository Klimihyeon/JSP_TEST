package io.ihyeon.mybatis;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class OracleMyBatisSqlSessionFactory implements SqlSessionFactory{

	private SqlSessionFactory sqlSessionFatory;
	{
		String config = "io/ihyeon/mybatis/sqlConfig.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(config);
			//java.io.reader임포트
			
			sqlSessionFatory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
			System.out.println("sqlSession 성공");
		} catch (Exception e) {
			System.out.println("sqlSession 실패");
			e.printStackTrace();
		}
	}//블록 생성자?
	
	
	
	//오버라이드를 원래꺼로 오버라이드. 
	
	@Override
	public Configuration getConfiguration() {
		return sqlSessionFatory.getConfiguration();
	}

	@Override
	public SqlSession openSession() {
		return sqlSessionFatory.openSession();
	}

	@Override
	public SqlSession openSession(boolean arg0) {
		return sqlSessionFatory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(Connection arg0) {
		return sqlSessionFatory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(TransactionIsolationLevel arg0) {
		return sqlSessionFatory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0) {
		return sqlSessionFatory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, boolean arg1) {
		return sqlSessionFatory.openSession(arg0, arg1);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, TransactionIsolationLevel arg1) {
		return sqlSessionFatory.openSession(arg0, arg1);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, Connection arg1) {
		return sqlSessionFatory.openSession(arg0, arg1);
	}

}
