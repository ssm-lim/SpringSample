package spring.web.app.board.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TB_BOARD")
@Data
public class Board {

	@Id
	private int boardNo; 
	private String boardId;
	
	private String writer;
	private LocalDateTime createDateTime;
	
	private String title;
	private String contents;
	
	private int depth;
	private int seq;
	
	private String updater;
	private LocalDateTime updateDateTime;
	
	private int hit;
}
