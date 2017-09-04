package spring.web.app.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.web.app.common.model.InterestsModel;
import spring.web.app.common.model.UserModel;
import spring.web.app.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public UserModel selectUser(String userid) throws Exception {
		return memberDAO.getUser(userid);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void insertUser(UserModel user) throws Exception {
		memberDAO.insertUser(user);
		String[] interests = user.getInterests();
		if(interests != null) {
			for(String interest : interests) {
				InterestsModel interestsModel = new InterestsModel();
				interestsModel.setUserId(user.getUserId());
				interestsModel.setInterest(interest);
				memberDAO.insertUserInterest(interestsModel);
			}
		}
	}
}
