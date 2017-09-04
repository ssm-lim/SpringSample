package spring.web.app.member.dao;

import org.springframework.stereotype.Repository;

import spring.web.app.common.dao.AbstractDAO;
import spring.web.app.common.model.InterestsModel;
import spring.web.app.common.model.UserModel;

@Repository
public class MemberDAO extends AbstractDAO {
    
	public UserModel getUser(String userid) throws Exception {
		return getSession().get(UserModel.class, "admin");
	}

	public void insertUser(UserModel user) throws Exception {
		getSession().save(user);
	}
	
	public void insertUserInterest(InterestsModel interest) throws Exception {
		getSession().save(interest);
	}
	
}

