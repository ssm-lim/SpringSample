package spring.web.app.system.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spring.web.app.system.security.model.UserInfo;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	SecurityService securityService;
	
	private RoleHierarchyImpl roleHierarchy;
	
	public CustomUserDetailsService(RoleHierarchyImpl roleHierarchy) {
        this.roleHierarchy = roleHierarchy;
    }

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		UserInfo user = securityService.getUserByUserId(userId);
		if(user == null) {
			throw new UsernameNotFoundException("존재하지 않는 사용자입니다.");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(user);
		
		if (user.getAuthority() == null) {
			throw new UsernameNotFoundException("권한정보가 없는 사용자입니다.");
        }
		
		return new User(user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, buildRoleAuthorities(authorities));
	}

	private Collection<? extends GrantedAuthority> buildRoleAuthorities(List<GrantedAuthority> authorities) {
		return roleHierarchy.getReachableGrantedAuthorities(authorities);
	}
	
}
