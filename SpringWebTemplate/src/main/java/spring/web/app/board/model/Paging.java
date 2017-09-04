package spring.web.app.board.model;

import lombok.Data;

@Data
public class Paging {

	public final int COUNT_PER_PAGE = 15;
	public final int COUNT_PER_PAGES = 10;
	
	private int totalCount;
	
	private int currentPage;
	
	private int prevPage;
	private int nextPage;
	
	private int lastPage;
	

	public Paging() {
	}
	
	public Paging(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public Paging(int currentPage, int totalCount) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		
//		paging();
	}
	
	private void paging() {
		
	}
}
