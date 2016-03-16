package spring.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.sample.dao.MemberDao;
import spring.sample.model.User;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	public List<Map<Integer, String>> getInterests() {
		return dao.getInterests();
	}

	public User selectUser(String userid) {
		return dao.getUser(userid);
	}
	
	@Transactional
	public Integer insertUser(User user) {
		System.out.println("---- insertUser ----");
		user.setUserno(dao.insertUser(user));
		return dao.insertUserInterest(user);
	}

}
