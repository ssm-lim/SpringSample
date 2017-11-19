package spring.web.app.system.security.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.app.system.security.dao.SecurityDAO;
import spring.web.app.system.security.model.RoleHierarchyModel;
import spring.web.app.system.security.model.UserInfo;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	SecurityDAO securityDAO;

	@Override
	public UserInfo getUserByUserId(String userId) {
		return securityDAO.getUserByUserId(userId);
	}

	@Override
	public String getRolesHierarchy() {
		List<RoleHierarchyModel> rolesHierarchy = securityDAO.getRolesHierarchy();
		if(rolesHierarchy != null){
			Iterator<RoleHierarchyModel> itr = rolesHierarchy.iterator();
	        StringBuffer concatedRoles = new StringBuffer();
	        RoleHierarchyModel model;
	        while (itr.hasNext()) {
	        	model = itr.next();
	        	if(model == null || model.getParentRole() == null) continue;
	        	concatedRoles.append(model.getParentRole().getRoleId());
	            concatedRoles.append(" > ");
	            concatedRoles.append(model.getRoleId());
	            concatedRoles.append("\n");
	        }
	        System.out.println(concatedRoles.toString());
	        return concatedRoles.toString();
		}
		return "";
	}

	@Override
	public List<Map<String, Object>> getRolesAndUrl() {
		return securityDAO.getRolesAndUrl();
	}

}
