package kr.co.collie.user.main.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.collie.user.main.domain.CategoryDomain;

public class MainDAO {

	private static MainDAO mDAO;

	private static SqlSessionFactory ssf;
	
	
	private MainDAO() {
	}
	
	
	public static MainDAO getInstance() {
		if(mDAO == null) {
			mDAO = new MainDAO();
		}
		return mDAO;
	}
	
	private SqlSession getSqlSession() {
		SqlSession ss=null;
		
		try {
			if(ssf==null) {
				//1.xml�� ����(buildpath���� included�� Excluded�� ��� ���� �ؾ� ��)
				String xmlConfig="kr/co/collie/user/dao/collie_config.xml";
				Reader reader=Resources.getResourceAsReader(xmlConfig);
				//2.MyBatis Framework ����
				ssf=new SqlSessionFactoryBuilder().build(reader);
				reader.close();//xml�� �о���� ��Ʈ���� ���´�.
			}//end if
			ss=ssf.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ss;
	}//getSqlSession
	
	
	/**
	 * ī�װ� ��� ��ȸ
	 * @return
	 */
	public List<CategoryDomain> selectCategoryList() {
		List<CategoryDomain> cateList = null;
		SqlSession ss = getSqlSession();
		cateList = ss.selectList("selectCateList");
		return cateList;
		
	}

	

}
