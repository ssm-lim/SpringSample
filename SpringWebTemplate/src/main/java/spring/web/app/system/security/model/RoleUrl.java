package spring.web.app.system.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SECURITY_ROLE_URL")
@Data
public class RoleUrl {

	@Id
    @Column(name = "URL")
	String url;
	
	@Column(name = "ACCESS_ROLE")
	String accessRole;

	@Column(name = "PRIORITY")
	int priority;
	
}
