package spring.web.app.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.web.app.member.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		
//		UserModel user = memberService.selectUser("");
//		model.addAttribute("user", user);
		
		return "/baseLayout/index";
	}
}
