package kr.co.collie.user.cart.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.collie.user.cart.domain.CartGoodsDomain;

public class CartDAO {
	private static CartDAO cDAO;
	private static SqlSessionFactory ssf;
	
	private CartDAO() {
		
	}//CartDAO
	
	public static CartDAO getInstance() {
		if(cDAO==null) {
			cDAO=new CartDAO();
		}//end if
		return cDAO;
	}//getInstance
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if(ssf==null) {
			//1.xml�� ����(buildpath���� included�� Excluded�� ��� ���� �ؾ� ��)
			String xmlConfig="kr/co/collie/user/dao/collie_config.xml";
			Reader reader=Resources.getResourceAsReader(xmlConfig);
			//2.MyBatis Framework ����
			ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();//xml�� �о���� ��Ʈ���� ���´�.
		}//end if
		
		return ssf;
	}//getSqlSession
	
	private SqlSession getSqlSession() {
		SqlSession ss=null;
		
		try {
			ss=getSqlSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ss;
	}//getSqlSession
	
	public List<CartGoodsDomain> selectCartGoods(int memberNum){
		List<CartGoodsDomain> list=null;
		
		SqlSession ss=getSqlSession();
		list=ss.selectList("selectCartGoods",memberNum);
		//MyBatis Handler ����
		ss.close();
		
		return list;
	}//selectCartGoods
	
}//class
