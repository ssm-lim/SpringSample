package spring.web.app.system.security.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import spring.web.app.system.security.model.UserInfo;

public interface SecurityService {
	
	public UserInfo getUserByUserId(String userId);
	
	
	/**
	 * ROLE의 계층 리스트를 가져온다.
	 * 
	 * @return CHILD > PARENT로 되어있는 계층정보 문자열
	 */
	public String getRolesHierarchy();

	/**
	 * ROLE의 계층 리스트를 가져온다.
	 * 
	 * @return URL과 ROLE의 매핑 리스트를 가져온다.
	 */
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndUrl();
}
