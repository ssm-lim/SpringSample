package spring.web.app.system.security.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import spring.web.app.system.security.dao.SecurityDAO;
import spring.web.app.system.security.model.RoleHierarchy;
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
		List<RoleHierarchy> rolesHierarchy = securityDAO.getRolesHierarchy();
		Iterator<RoleHierarchy> itr = rolesHierarchy.iterator();
        StringBuffer concatedRoles = new StringBuffer();
        while (itr.hasNext()) {
        	RoleHierarchy model = itr.next();
        	if(model.getParentRole() != null) {
        		concatedRoles.append(model.getParentRole().getRoleId());
                concatedRoles.append(" > ");
                concatedRoles.append(model.getRoleId());
                concatedRoles.append("\n");
        	}
        }
        return concatedRoles.toString();
	}

	@Override
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
