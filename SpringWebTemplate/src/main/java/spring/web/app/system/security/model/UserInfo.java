package spring.web.app.system.security.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Table(name="TB_USER")
@Data
public class UserInfo implements GrantedAuthority {
	
	private static final long serialVersionUID = 7877665293796267911L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNo;
	@Id
	private String userId;
	private String password;
	private String userName;
	private String roleId;
	private int point;
	private LocalDateTime lastDate;
	
	@Transient
	private boolean isEnabled = true;

	@Override
	public String getAuthority() {
		return this.roleId;
	}
}
