package spring.web.app.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;


@Data
@Entity
@Table(name="TB_USER")
public class UserModel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNo;
	@Id
	private String userId;
	private String password;
	private String userName;
	private String email;
	private int point;
	private String role;
	private Date regDate;
	private Date lastDate;
	@Column(name="GENDER", columnDefinition="char(1)")
	private String gender;
	@Transient
	private String[] interests;
	
}
