package spring.sample.dao;

import java.util.List;
import java.util.Map;

import spring.sample.model.User;

public interface MemberDao {
	public List<Map<Integer, String>> getInterests();
	public User getUser(String userid);
	public int insertUser(User user);
	public int insertUserInterest(User user);
}
