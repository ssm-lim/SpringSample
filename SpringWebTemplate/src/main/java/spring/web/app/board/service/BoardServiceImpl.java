package spring.web.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.app.board.dao.BoardDAO;
import spring.web.app.board.model.Board;
import spring.web.app.board.model.Paging;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<Board> getBoardList(Board board, Paging paging) {
		return boardDAO.getBoardList(board, paging);
	}

	@Override
	public int getBoardCount() {
		return 0;
	}

	@Override
	public Board getBoardContent() {
		return null;
	}

	@Override
	public int saveBoardContent(Board board) {
		return 0;
	}

	@Override
	public void deleteBoard(Board board) {

	}

}
