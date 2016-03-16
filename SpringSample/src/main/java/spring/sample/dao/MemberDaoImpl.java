package spring.sample.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import spring.sample.model.User;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	String namespace = "mappers.MemberMapper.";

    @Autowired
    SqlSessionTemplate session;
    
	@Override
	public List<Map<Integer, String>> getInterests() {
		return session.selectList(namespace + "getInterests");
	}

	@Override
	public User getUser(String userid) {
		return session.selectOne(namespace + "getUser", userid);
	}

	@Override
	public int insertUser(User user) {
		return session.insert(namespace + "insertUserInfo", user);
	}

	@Override
	public int insertUserInterest(User user) {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(String interest : user.getInterests()){
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("userid", user.getUserid());
			paramMap.put("interest", interest);
			list.add(paramMap);
		}
		return session.insert(namespace + "insertUserInterest", list);
	}
	
}

