package spring.web.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.web.app.board.model.Board;
import spring.web.app.board.model.Paging;
import spring.web.app.board.service.BoardService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(method=RequestMethod.GET, value="/admin")
	public String listView(Board board, Paging paging){
//		System.out.println(boardService.getBoardList(board, paging));
		return "/baseLayout/board/board";
	}
	@RequestMapping(method=RequestMethod.GET)
	public String listaView(Board board, Paging paging){
//		System.out.println(boardService.getBoardList(board, paging));
		return "/baseLayout/board/board";
	}
}
