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
	private long boardNo; 
	private String boardId;
	
	private String writer;
	private LocalDateTime createDateTime;
	
	private String title;
	private String contents;
	
	private short depth;
	private short seq;
	
	private String updater;
	private LocalDateTime updateDateTime;
	
	private int hit;
	private int recommend;
}
