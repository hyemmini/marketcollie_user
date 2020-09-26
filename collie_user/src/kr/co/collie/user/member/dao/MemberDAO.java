package kr.co.collie.user.member.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.user.dao.GetCollieHandler;
import kr.co.collie.user.member.domain.LoginDomain;
import kr.co.collie.user.member.vo.FindIdVO;
import kr.co.collie.user.member.vo.JoinVO;
import kr.co.collie.user.member.vo.LoginVO;

public class MemberDAO {
	
	private static MemberDAO memDAO;
	
	private MemberDAO() {
		
	}

	public static MemberDAO getInstance() {
		if(memDAO==null) {
			memDAO = new MemberDAO();
		}//end if
		
		return memDAO;
	}//getInstance
	
	public LoginDomain selectLogin(LoginVO loginVO) {
		LoginDomain logindomain = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		
		logindomain = ss.selectOne("kr.co.collie.user.member.selectLogin",loginVO);
		ss.close();
		return logindomain;
	}//loginDomain
	
	public void insertMember(JoinVO jVO) throws IOException{
			
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
			
		ss.insert("insertMember", jVO);
			
		ss.commit();
			
		ss.close();
			
	}//insertMember
	
	public String selectMemberId(FindIdVO fidVO) {
		String id = "";
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		id = ss.selectOne("kr.co.collie.user.member.selectMemberId",fidVO);
//		fidVO.setEmail("gildong@gmail.com");
//		fidVO.setName("�۱浿");
		ss.close();
		return id;
	}
	
	public int dupId(String id) {
		int dup = 0;
		
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		dup = ss.selectOne("dupId", id);
		ss.close();
				
		
		return dup;
	}//dupId
	
	
		public static void main(String[] args) {
			
			System.out.println(memDAO.getInstance().dupId("dd"));
			
		}
	
}//class
