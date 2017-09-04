package spring.web.app.system.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import spring.web.app.system.security.dao.SecurityDAO;

public class CustomRoleHierarchyImpl extends RoleHierarchyImpl {

	@Autowired
	SecurityDAO securityDAO;
	
	public CustomRoleHierarchyImpl() {
		super();
	}
	
	@Override
	public void setHierarchy(String roleHierarchyStringRepresentation) {
		super.setHierarchy(roleHierarchyStringRepresentation);
	}

}
