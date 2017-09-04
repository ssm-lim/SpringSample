package spring.web.app.board.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import spring.web.app.board.model.Board;
import spring.web.app.board.model.Paging;
import spring.web.app.common.dao.AbstractDAO;

@Repository
@SuppressWarnings("unchecked")
public class BoardDAO extends AbstractDAO {
	
	public List<Board> getBoardList(Board board, Paging paging) {
		Query query = getSession().createQuery("FROM Board WHERE boardId = '" + board.getBoardId() + "'");
		query.setFirstResult((paging.getCurrentPage() - 1) * paging.COUNT_PER_PAGE);
        query.setMaxResults(paging.COUNT_PER_PAGE);
		return query.getResultList();
	}

	public int getBoardCount() {
		return 0;
	}

	public Board getBoardContent() {
		return null;
	}

	public int saveBoardContent(Board board) {
		return 0;
	}

	public void deleteBoard(Board board) {

	}
}
