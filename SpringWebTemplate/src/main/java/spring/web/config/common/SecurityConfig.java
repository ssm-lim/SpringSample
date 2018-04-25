package spring.web.config.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import spring.web.app.system.security.service.CustomUserDetailsService;
import spring.web.app.system.security.service.ReloadableFilterInvocationSecurityMetadataSource;
import spring.web.app.system.security.service.RoleAndUrlResourcesMapLoader;
import spring.web.app.system.security.service.RoleHierarchyLoader;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.addFilterAfter(filterSecurityInterceptor(), FilterSecurityInterceptor.class)
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
//				.antMatchers("/").permitAll()
				.and()
			.formLogin()
				.loginProcessingUrl("/auth/login/process")
				.loginPage("/auth/login")
				.failureUrl("/auth/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/auth/logout")
//				.logoutSuccessHandler(null)
				.invalidateHttpSession(true)
				.and()
			.csrf()
				.disable();
	}
	
//	@Bean
//	public AuthenticationSuccessHandler successHandler() {
//	    return new LoginSuccessHandler("/");
//	}

	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
	
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
//      authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
	
	@Bean 
	public UserDetailsService userDetailsService() {
		UserDetailsService userDetail = new CustomUserDetailsService(roleHierarchy());
		return userDetail;
	}
	
	@Bean public RoleHierarchyLoader roleHierarchyLoader() {
		return new RoleHierarchyLoader();
	}
	
	@Bean public RoleHierarchyImpl roleHierarchy() {
		return roleHierarchyLoader().getRoleHierarchyImpl();
	}
	
	@Bean
	public FilterSecurityInterceptor filterSecurityInterceptor() throws Exception {
		FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
		filterSecurityInterceptor.setAuthenticationManager(authenticationManagerBean());
		filterSecurityInterceptor.setSecurityMetadataSource(reloadableFilterInvocationSecurityMetadataSource());
		filterSecurityInterceptor.setAccessDecisionManager(affirmativeBased());
		return filterSecurityInterceptor;
	}
	
	@Bean
	public AffirmativeBased affirmativeBased() {
	  List<AccessDecisionVoter<? extends Object>> accessDecisionVoters = new ArrayList<>();
	  accessDecisionVoters.add(roleVoter());
	  AffirmativeBased affirmativeBased = new AffirmativeBased(accessDecisionVoters);
	  return affirmativeBased;
	}
	
	@Bean
	public RoleHierarchyVoter roleVoter() {
		return new RoleHierarchyVoter(roleHierarchy());
	}
	
	@Bean public FilterInvocationSecurityMetadataSource reloadableFilterInvocationSecurityMetadataSource() {
		return new ReloadableFilterInvocationSecurityMetadataSource(roleAndUrlResourcesMapLoader());
	}
	
	@Bean public RoleAndUrlResourcesMapLoader roleAndUrlResourcesMapLoader() {
		return new RoleAndUrlResourcesMapLoader();
	}
	
//	private CsrfTokenRepository csrfTokenRepository() 
//	{ 
//	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository(); 
//	    repository.setSessionAttributeName("_csrf");
//	    return repository; 
//	}
}
