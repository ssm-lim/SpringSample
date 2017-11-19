package spring.web.app.system.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

public class RoleHierarchyLoader {

	@Autowired
	SecurityService securityService;
	
	private RoleHierarchyImpl roleHierarchyImpl;

	public RoleHierarchyLoader() {
		super();
		roleHierarchyImpl = new RoleHierarchyImpl();
	}

	public RoleHierarchyImpl getRoleHierarchyImpl() {
		getRoleHierarchy();
		return roleHierarchyImpl;
	}
	
	public void getRoleHierarchy() {
		roleHierarchyImpl.setHierarchy(securityService.getRolesHierarchy());
	}
	
	public void setRoleHierarchy(String roleHierarchyString) {
		roleHierarchyImpl.setHierarchy(roleHierarchyString);
	}
	
}
