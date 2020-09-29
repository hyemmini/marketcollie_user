package kr.co.collie.user.mypage.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.collie.user.member.domain.LoginDomain;
import kr.co.collie.user.mypage.domain.QnaDetailDomain;
import kr.co.collie.user.mypage.service.MypageService;
import kr.co.collie.user.mypage.vo.MyOrderVO;
import kr.co.collie.user.mypage.vo.PassCheckVO;
import kr.co.collie.user.mypage.vo.QnaVO;
import kr.co.collie.user.mypage.vo.UpdatePassVO;

@Controller
public class MypageController {
	
	@RequestMapping(value="/mypage/memberinfo_form.do" , method=GET)
	public String memberInfoForm(HttpSession session, Model model, PassCheckVO pcVO ) {
		
		String pass = (String)session.getAttribute("pass");
		
		return "mypage/memberinfo";
	}//memberInfoForm
	
	//String id?
	/**
	 * �ֹ����� ����� �ҷ����� ��
	 * @param session
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/mypage/order_list.do")
	public String orderList(HttpSession session, String id, Model model) {
		
		return "mypage/order_list";
	}//orderList
	
	/**
	 * �ֹ����� �󼼸� �ҷ����� ��
	 * @param moVO
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/mypage/order_detail.do")
	public String orderDetail(MyOrderVO moVO, HttpSession session, Model model) {
		
		return "mypage/order_detail";
	}//orderDetail
	
	/**
	 * �ֹ������� ����ϴ� ��
	 * @param moVO
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/mypage/order_cancel.do")
	public String cancelOrder(MyOrderVO moVO, HttpSession session, Model model) {
		
		return "mypage/order_cancel";
	}//orderList
	
	/**
	 * ���������� - ��й�ȣ ���� : ���� ��й�ȣ Ȯ���ϴ� ��
	 * @return
	 */
	@RequestMapping(value="/mypage/check_pass_form.do", method=GET)
	public String checkPassForm() {
		return "mypage/check_pass_form";
	}//checkPassForm
	
	/**
	 * ���������� - ��й�ȣ ���� : ���� ��й�ȣ Ȯ���ϴ� ��
	 * @param pcVO
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/mypage/check_pass.do", method=POST)
	public String checkPass(PassCheckVO pcVO, HttpSession session, Model model) {
		LoginDomain ld = (LoginDomain) session.getAttribute("user_info");
		//pcVO.setMember_num(ld.getMember_num());
		pcVO.setMember_num(1); ///////////////////////////////////////// �ӽð�
		
		MypageService ms = new MypageService();
		try {
			boolean flag = ms.getMemberPass(pcVO);
		} catch(NullPointerException npe) {
			model.addAttribute("msg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}//end catch
		
		return "forward:/mypage/modify_pass_form.do";
	}//checkPassForm
	
	/**
	 * ��й�ȣ �����ϱ� ���� ��
	 * @return
	 */
	@RequestMapping(value="/mypage/modify_pass_form.do", method=POST)
	public String modifyPassForm() {
		return "mypage/modify_pass_form";
	}//modifyPassForm
	
	/**
	 * ��й�ȣ �����ϴ� ��
	 * @param upVO
	 * @return
	 */
	@RequestMapping(value="/mypage/modify_pass.do", method=POST)
	public String modifyPass(UpdatePassVO upVO, HttpSession session, Model model) {
		LoginDomain ld = (LoginDomain) session.getAttribute("user_info");
		//upVO.setMember_num(ld.getMember_num());
		upVO.setMember_num(1); /////////////////////////�ӽð�
		
		MypageService ms = new MypageService();
		boolean flag = ms.modifyPass(upVO);
		
		return "redirect:modify_pass_result.jsp";
	}//checkPassForm
	
	@RequestMapping(value = "/mypage/qna_list.do",method = {GET,POST})
	public String qnaList(String mNum,Model model,HttpSession ss) {
		
		MypageService ms = new MypageService();
		model.addAttribute("qna_list",ms.getQnaList(Integer.parseInt(mNum)));
		
		return "mypage/qna_list";
	}
	@RequestMapping(value = "/mypage/qna_detail.do",method = GET)
	public String qnaDetail(String qNum, HttpSession session, Model model) throws NumberFormatException {
		
		QnaVO qVO=new QnaVO();
		LoginDomain lDomain=(LoginDomain)session.getAttribute("user_info");
		qVO.setMember_num(lDomain.getMember_num());
		qVO.setQna_num(Integer.parseInt(qNum));
		
		MypageService ms = new MypageService();
		QnaDetailDomain qdd=ms.getQnaDetail(qVO);
		model.addAttribute("qna_data",qdd);
		
		return "mypage/qna_detail";
		
	}
	
	
}//MypageController
