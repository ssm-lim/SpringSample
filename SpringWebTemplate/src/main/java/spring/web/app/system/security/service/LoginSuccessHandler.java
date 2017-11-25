/** 
 * LoginSuccessHandler.java
 * @author 임새미 
 * @since 2016. 10. 11.
 *
 *  	 수정일                     수정자                                       수정내용
 *  -------------	--------	---------------------------
 *  2016. 10. 11. 	    임새미				       최초생성
 * 
 */
package spring.web.app.system.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	// SavedRequestAwareAuthenticationSuccessHandler  <- 로그인 전 페이지로 이동
	// http://chomman.github.io/blog/java/spring%20security/programming/spring-security-redirect-previous-after-login/
	
	public LoginSuccessHandler(String defaultTargetUrl) {
		setDefaultTargetUrl(defaultTargetUrl);
	}
	
	/**
	 * security 인증 성공 이후의 절차를 진행한다.
	 * 
	 * @param request request객체
	 * @param response response객체
	 * @param authentication authentication객체
	 * @exception IOException, ServletException 입출력, 서블릿 예외
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		
		// 사용자 정보 가져와서 세션에 넣기
		
		// 사용자 로그인 로그 넣기
		
		HttpSession session = request.getSession();
        if (session != null) {
            String redirectUrl = (String) session.getAttribute("prevPage");
            if (redirectUrl != null) {
                session.removeAttribute("prevPage");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
	}
}
