package spring.web.app.system.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import spring.web.app.common.dao.AbstractDAO;
import spring.web.app.system.security.model.RoleHierarchy;
import spring.web.app.system.security.model.UserInfo;

@Repository
@SuppressWarnings({"rawtypes", "unchecked"})
public class SecurityDAO extends AbstractDAO {
	
	public UserInfo getUserByUserId(String username) {
		return getSession().get(UserInfo.class, username);
	}

	public List<RoleHierarchy> getRolesHierarchy() {
		List<RoleHierarchy> rolesHierarchy = new ArrayList<RoleHierarchy>();
		try {
			Query query = getSession().createQuery("From RoleHierarchy");
			rolesHierarchy = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rolesHierarchy;
	}
}
