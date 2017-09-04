package spring.web.app.common.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TB_INTERESTS")
public class InterestsModel {
	
	@Id
	private int interestId;
	private String userId;
	private String interest;

}
