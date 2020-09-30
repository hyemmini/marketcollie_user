package kr.co.collie.user.qna.service;

import kr.co.collie.user.qna.dao.QnaDAO;
import kr.co.collie.user.qna.vo.QnaAddVO;

public class QnaService {
	
	public boolean addQna(QnaAddVO qaVO) {
		boolean flag = false; //�Է� ����? �� 
		
		QnaDAO qDAO = QnaDAO.getInstance();
		qDAO.insertQna(qaVO);
		
		if(qaVO==null) {
			flag=true; //����� ���� �ȵ�
		}//end if
		
		return flag; //�����ϸ� false ����
	}//addQna
}
