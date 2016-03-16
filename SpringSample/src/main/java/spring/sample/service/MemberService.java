package spring.sample.service;

import java.util.List;
import java.util.Map;

import spring.sample.model.User;

public interface MemberService {
	
	public List<Map<Integer, String>> getInterests();
	public User selectUser(String userid);
	public Integer insertUser(User tbUser);
}
