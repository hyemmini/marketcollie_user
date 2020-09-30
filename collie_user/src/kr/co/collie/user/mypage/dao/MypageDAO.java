package kr.co.collie.user.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.collie.user.dao.GetCollieHandler;
import kr.co.collie.user.mypage.domain.MemberInfoDomain;
import kr.co.collie.user.mypage.domain.OrderListDomain;
import kr.co.collie.user.mypage.domain.QnaDetailDomain;
import kr.co.collie.user.mypage.domain.QnaListDomain;
import kr.co.collie.user.mypage.vo.DeleteMemberVO;
import kr.co.collie.user.mypage.vo.ModifyMemberVO;
import kr.co.collie.user.mypage.vo.PassCheckVO;
import kr.co.collie.user.mypage.vo.QnaVO;
import kr.co.collie.user.mypage.vo.UpdatePassVO;
import kr.co.collie.user.pagination.RangeVO;

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
      * �ֹ� ���� ����� �ҷ����� ��
     * @param rVO
     * @return
     */
    public List<OrderListDomain> selectOrderList(RangeVO rVO){
    	 List<OrderListDomain> list = null;
    	 
    	 SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
    	 list = ss.selectList("kr.co.collie.user.mypage.selectOrderList", rVO);
    	 ss.close();
    	 
    	 return list;
     }//selectOrderList
    
    /**
     * �ֹ� ���� ��� ���������̼��� ���� ������ ���� ��
     * @param rVO
     * @return
     */
    public int selectOrderListCnt(RangeVO rVO) {
    	int cnt = 0;
    	
    	SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
    	cnt = ss.selectOne("kr.co.collie.user.mypage.selectOrderListCnt", rVO);
    	ss.close();
    	
    	return cnt;
    }//selectOrderListCnt

     
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
     * ��� ���� ��������
     * @param pcVO
     * @return
     */
    public MemberInfoDomain selectMemberInfo(PassCheckVO pcVO) {
    	 MemberInfoDomain mid = null;
    	 SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
    	 
    	 mid = ss.selectOne("kr.co.collie.user.mypage.selectMemberInfo", pcVO);
    	 
    	 ss.close();
    	 
    	 return mid;
     }//selectMemberInfo
     
     
     /**
     * ������� ����
     * @param mmVO
     * @return
     */
    public int updateMemberInfo(ModifyMemberVO mmVO) {
         int cnt =0;
         
         SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
         
         cnt = ss.update("kr.co.collie.user.mypage.updateMember", mmVO);
         ss.close();
         
         return cnt;
     }//updateMemberInfo
    
    
    public int deleteMember(DeleteMemberVO dmVO) {
    	int cnt = 0;
    	
    	SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
    	cnt = ss.update("kr.co.collie.user.mypage.removeMember", dmVO);
    	
    	ss.close();
    	return cnt;
    }//deleteMember
     
    
    public static void main(String[] args) {
    	DeleteMemberVO dm = new  DeleteMemberVO();
    	dm.setMember_num(50);
		dm.setPass("tZxnvxlqR1gZHkL3ZnDOug==");
    	MypageDAO mDAO = MypageDAO.getInstance();
    	
    	System.out.println(mDAO.deleteMember(dm));
	}
    
	/**
	 * ��й�ȣ�� �����ϴ� ��.
	 * @param upVO
	 * @return
	 */
	public int updateMemberPass(UpdatePassVO upVO) {
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		int cnt = ss.update("kr.co.collie.user.mypage.updateMemberPass", upVO);
		ss.commit();
		ss.close();
		
		return cnt;
	}//updateMemberPass
	
	public List<QnaListDomain> selectQnaList(int mNum){
		List<QnaListDomain> list = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		list = ss.selectList("selectQnaList");
		ss.close();
		
		return list;
	}//selectQnaList
	
	public QnaDetailDomain selectQnaDetail(QnaVO qVO) {
		QnaDetailDomain qdd = null;
		SqlSession ss = GetCollieHandler.getInstance().getSqlSession();
		qdd = ss.selectOne("selectQnaDetail",qVO);
		ss.close();
		return qdd;
	}
	
}//class
