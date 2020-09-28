package kr.co.collie.user.mypage.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.user.dao.GetCollieHandler;
import kr.co.collie.user.mypage.vo.PassCheckVO;
import kr.co.collie.user.mypage.vo.UpdatePassVO;
import oracle.net.aso.s;

public class MypageDAO {
	private static MypageDAO mpDAO;
	
	private MypageDAO() {
	}//MypageDAO
	
	public static MypageDAO getInstance() {
		if( mpDAO == null ) {
			mpDAO = new MypageDAO();
		}//end if
		return mpDAO;
	}//getInstance
	
	/**
	 * ���� ��й�ȣ�� Ȯ���ϴ� ��
	 * @param pcVO
	 * @return
	 */
	public int selectMemberPass(PassCheckVO pcVO) {
		int member_num = 0;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		member_num = ss.selectOne("kr.co.collie.user.mypage.selectMemberPass", pcVO);
		ss.close();
		
		return member_num;
	}//selectMemberPass
	
	/**
	 * ��й�ȣ�� �����ϴ� ��.
	 * @param upVO
	 * @return
	 */
	public int updateMemberPass(UpdatePassVO upVO) {
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		int cnt = ss.update("kr.co.collie.user.mypage.updateMemberPass", upVO);
		ss.close();
		
		return cnt;
	}//updateMemberPass
	
}//class
