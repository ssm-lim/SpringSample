package spring.web.app.system.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SECURITY_ROLE")
public class SecurityRole {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int roleNo;
	@Id
	String roleId;
	String roleName;
	char useYn;
	char editable;

}
