package kr.co.collie.user.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.collie.user.main.domain.CategoryDomain;
import kr.co.collie.user.main.service.MainService;
import kr.co.collie.user.member.domain.LoginDomain;

@SessionAttributes("cate_list")
@Controller
public class MainController {
	
	@RequestMapping(value="/index.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model, HttpSession session) {
		MainService ms = new MainService();
		List<CategoryDomain> cateList = ms.getCategories();
//		//�α��� ������ �� �Ϸ�Ǹ�
		//���ǿ� user_info�� ������ header�� �α׾ƿ� / ������������ ����
		//user_info�� ������ haeder�� �α��� / ȸ���������� ����
		Object loginSession = session.getAttribute("user_info") ;
		if(loginSession != null && loginSession instanceof LoginDomain) {
			LoginDomain ld = (LoginDomain)session.getAttribute("user_info");
			session.setAttribute("user_info", ld); 
		}
		
		model.addAttribute("cate_list",cateList);
		
		return "main";
	}//main
	
	
}//class
