package spring.web.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.web.app.board.model.Board;
import spring.web.app.board.model.Paging;
import spring.web.app.board.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listView(Board board, Paging paging){
		System.out.println(boardService.getBoardList(board, paging));
		return "/baseLayout/board/board";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public String saveView(){
		return "/baseLayout/board/board_write";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(){
		return "/baseLayout/board/board_write";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String contentsView(){
		return "/baseLayout/board/board_view";
	}
}
