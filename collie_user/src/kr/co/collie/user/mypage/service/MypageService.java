package kr.co.collie.user.mypage.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import kr.co.collie.user.mypage.dao.MypageDAO;
import kr.co.collie.user.mypage.domain.MemberInfoDomain;
import kr.co.collie.user.mypage.vo.DeleteMemberVO;
import kr.co.collie.user.mypage.vo.ModifyMemberVO;
import kr.co.collie.user.mypage.domain.QnaDetailDomain;
import kr.co.collie.user.mypage.domain.QnaListDomain;
import kr.co.collie.user.mypage.vo.PassCheckVO;
import kr.co.collie.user.mypage.vo.QnaVO;
import kr.co.collie.user.mypage.vo.UpdatePassVO;
import kr.co.sist.util.cipher.DataEncrypt;

public class MypageService {
	/**
	 * ���� ��й�ȣ�� Ȯ���ϴ� ��
	 * @param pcVO
	 * @return
	 */
	public boolean getMemberPass(PassCheckVO pcVO) {
		boolean flag = false;
		
		MypageDAO mpDAO = MypageDAO.getInstance();
		try {
			pcVO.setPass(DataEncrypt.messageDigest("MD5", pcVO.getPass()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//end catch
		flag = mpDAO.selectMemberPass(pcVO) != 0;
		
		return flag;
	}//getMemberPass
	
	/**
	 * ��й�ȣ�� �����ϴ� ��
	 * @param upVO
	 * @return
	 */
	public boolean modifyPass(UpdatePassVO upVO) {
		boolean flag = false;
		
		MypageDAO mpDAO = MypageDAO.getInstance();
		try {
			upVO.setPass(DataEncrypt.messageDigest("MD5", upVO.getPass()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//end catch
		flag = mpDAO.updateMemberPass(upVO)==1;
		
		return flag;
	}//modifyPass
	
	/**
	 * ��� ���� ��������
	 * @param pcVO
	 * @return
	 */
	public MemberInfoDomain getMemberInfo(PassCheckVO pcVO) {
		MemberInfoDomain  mid = null;
		
		MypageDAO mDAO = MypageDAO.getInstance();
		
		mid=mDAO.selectMemberInfo(pcVO);
		
		
		return mid;
	}//getMemberInfo
	
	
	/**
	 * ��� ���� ����
	 * @param mmVO
	 * @return
	 */
	public boolean modifyMemberInfo(ModifyMemberVO mmVO) {
		boolean flag = false;
		
		MypageDAO mDAO = MypageDAO.getInstance();
		flag = mDAO.updateMemberInfo(mmVO)!=0;
		
		return flag;
	}//modifyMemberInfo
	
	public boolean removeMember(DeleteMemberVO dmVO) {
		
		boolean flag=false;
		
		MypageDAO mDAO = MypageDAO.getInstance();
		flag = mDAO.deleteMember(dmVO)!=0;
		
		return flag;
		
	}//removeMember
	
	public List<QnaListDomain> getQnaList(int mNum){
		List<QnaListDomain> list = null;
		MypageDAO mpDAO = MypageDAO.getInstance();
		list = mpDAO.selectQnaList(mNum);
		return list;
	}//getQnaList
	
	
	public QnaDetailDomain getQnaDetail(QnaVO qVO) {
		QnaDetailDomain qdd = null;
		
		MypageDAO mpDAO = MypageDAO.getInstance();
		qdd=mpDAO.selectQnaDetail(qVO);
		
		return qdd;
	}//getQnaDetail
	
}//class

	
	
