package kr.co.collie.user.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Controller
public class MemberController {
	
	@RequestMapping(value="/join_form.do", method =GET)
	public String joinForm() {
		
		
		return "";
	}
	
}//class
