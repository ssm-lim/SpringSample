package spring.web.app.system.security.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import spring.web.app.common.dao.AbstractDAO;
import spring.web.app.system.security.model.RoleHierarchyModel;
import spring.web.app.system.security.model.UserInfo;

@Repository
@SuppressWarnings({"rawtypes", "unchecked"})
public class SecurityDAO extends AbstractDAO {
	
	public UserInfo getUserByUserId(String username) {
		return getSession().get(UserInfo.class, username);
	}

	public List<RoleHierarchyModel> getRolesHierarchy() {
		List<RoleHierarchyModel> rolesHierarchy = null;
		try {
			Query query = getSession().createQuery(""
					+ "SELECT DISTINCT R2 "
					+ "FROM RoleHierarchyModel R1 "
					+ "INNER JOIN R1.role R2 "
					+ "ORDER BY R2.parentRole ");
			rolesHierarchy = (List<RoleHierarchyModel>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rolesHierarchy;
	}
	
	public List<Map<String, Object>> getRolesAndUrl() {
		return getSession().createQuery("SELECT new Map(roleUrl.url AS url, roleUrl.accessRole AS accessRole) FROM RoleUrl roleUrl").list();
	}

}
