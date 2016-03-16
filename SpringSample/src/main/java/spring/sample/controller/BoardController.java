package spring.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(){
		return "/board/board";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "/board/board_write";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(){
		return "/board/board_update";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(){
		return "/board/board_view";
	}
}
