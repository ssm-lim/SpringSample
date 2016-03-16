package spring.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.sample.model.User;
import spring.sample.service.MemberService;
import spring.sample.validator.JoinValidator;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String gojoin(Model model){
		model.addAttribute("interests", service.getInterests());
		model.addAttribute("user", new User());
		return "member/member_join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String doJoin(Model model, User user, BindingResult bindingResult){
		boolean noError = true;
		new JoinValidator().validate(user, bindingResult);
		if(bindingResult.hasErrors()){
			noError = false;
		} else if(service.selectUser(user.getUserid()) != null){
			noError = false;
			bindingResult.rejectValue("userid", "join.userid.duplicated");
		}
		
		if(noError){
			if(service.insertUser(user) == 0){
				return "/error/error";
			} else {
				model.addAttribute("name", user.getName());
				return "member/member_join_complete";
			}
		} else {
			user.setPassword("");
			model.addAttribute("user", user);
			model.addAttribute("interests", service.getInterests());
			return "member/member_join";
		}
	}
}
