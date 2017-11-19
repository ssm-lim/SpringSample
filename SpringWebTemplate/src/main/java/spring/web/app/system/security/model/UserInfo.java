package spring.web.app.system.security.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
@Table(name="TB_USER")
public class UserInfo implements GrantedAuthority {
	
	private static final long serialVersionUID = 7877665293796267911L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNo;
	@Id
	private String userId;
	private transient String password;
	private String userName;
	private String roleId;
	private int point;
	private Date lastDate;
	
	private boolean isEnabled = true;

	@Override
	public String getAuthority() {
		return this.roleId;
	}
	
	
}
