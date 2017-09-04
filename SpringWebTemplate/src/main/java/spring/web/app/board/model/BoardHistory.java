package spring.web.app.board.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TB_BOARD_HISTORY")
@Data
public class BoardHistory {
	@Id
	private long boardNo; 
	private String updater;
	private LocalDateTime updateDateTime;
	private String title;
	private String contents;
}
