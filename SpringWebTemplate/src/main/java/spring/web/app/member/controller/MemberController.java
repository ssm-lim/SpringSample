package spring.web.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.web.app.common.model.UserModel;
import spring.web.app.member.service.MemberService;
import spring.web.app.member.validator.JoinValidator;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String gojoin(Model model){
		model.addAttribute("user", new UserModel());
		return "/baseLayout/member/member_join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String doJoin(Model model, UserModel user, BindingResult bindingResult) throws Exception {
		boolean noError = true;
		new JoinValidator().validate(user, bindingResult);
		if(bindingResult.hasErrors()){
			noError = false;
		} else if(memberService.selectUser(user.getUserId()) != null){
			noError = false;
			bindingResult.rejectValue("userId", "join.userId.duplicated");
		}
		
		if(noError){
			try {
				memberService.insertUser(user);
				
				model.addAttribute("name", user.getUserName());
				return "/baseLayout/member/member_join_complete";
				
			} catch (Exception e) {
				e.printStackTrace();
				return "/error/error";
			}
		} else {
			user.setPassword("");
			model.addAttribute("user", user);
			return "/baseLayout/member/member_join";
		}
	}
}
