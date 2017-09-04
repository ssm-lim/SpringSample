package spring.web.app.board.service;

import java.util.List;

import spring.web.app.board.model.Board;
import spring.web.app.board.model.Paging;

public interface BoardService {

	public List<Board> getBoardList(Board board, Paging paging);
	
	public int getBoardCount();
	
	public Board getBoardContent();
	
	public int saveBoardContent(Board board);
	
	public void deleteBoard(Board board);
}
