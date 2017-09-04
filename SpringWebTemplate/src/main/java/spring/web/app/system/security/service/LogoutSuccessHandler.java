package spring.web.app.system.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/** 
 * LogoutSuccessHandler.java
 * @author 임새미 
 * @since 2016. 11. 11.
 *
 *  	 수정일                     수정자                                       수정내용
 *  -------------	--------	---------------------------
 *  2016. 11. 11. 	    임새미				       최초생성
 * 
 */
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	
	private String successUrl = "/loginView.do";
	
	public void setSuccessUrl(String successUrl){
		this.successUrl = successUrl;
	}
	
	 @Override
	    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

	        if (authentication != null) {
	        	Object principal = authentication.getPrincipal();
	            if (principal instanceof UserDetails) {
	            	// principal = 로그아웃 대상 정보 
	            	
	            	// 로그아웃 저장
	            }
	        }

	        setDefaultTargetUrl(successUrl);
	        super.onLogoutSuccess(request, response, authentication);       
	    }
}
