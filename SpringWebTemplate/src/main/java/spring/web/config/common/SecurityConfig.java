package spring.web.config.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import spring.web.app.system.security.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/board/**").authenticated()
				.antMatchers("/auth/login", "/auth/login/*").permitAll()
				.antMatchers("/").permitAll()
				.and()
			.formLogin()
				.loginProcessingUrl("/auth/login/process")
				.loginPage("/auth/login")
				.failureUrl("/auth/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
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
	
	@Bean 
	public UserDetailsService userDetailsService() {
		UserDetailsService userDetail = new CustomUserDetailsService();
		return userDetail;
	}
	
}
