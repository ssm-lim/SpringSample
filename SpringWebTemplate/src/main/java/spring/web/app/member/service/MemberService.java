package spring.web.app.member.service;

import spring.web.app.common.model.UserModel;

public interface MemberService {
	
	public UserModel selectUser(String userid) throws Exception;
	public void insertUser(UserModel user) throws Exception;
}
