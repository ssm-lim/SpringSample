package spring.web.app.system.security.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class ReloadableFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private RoleAndUrlResourcesMapLoader roleAndUrlResourcesMapLoader;
	
	private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> requestMap;

	public ReloadableFilterInvocationSecurityMetadataSource(RoleAndUrlResourcesMapLoader roleAndUrlResourcesMapLoader) {
        this.roleAndUrlResourcesMapLoader = roleAndUrlResourcesMapLoader;
    }
	
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRoleAndUrlResourcesMap() {
		return roleAndUrlResourcesMapLoader.getRoleAndUrlResourcesMap();
	}

    public Collection<ConfigAttribute> getAllConfigAttributes() {
    	if(this.requestMap == null) this.requestMap = getRoleAndUrlResourcesMap();
    	
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        for (Map.Entry<RequestMatcher, List<ConfigAttribute>> entry : requestMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        return allAttributes;
    }

    public Collection<ConfigAttribute> getAttributes(Object object) {
    	if(this.requestMap == null) this.requestMap = getRoleAndUrlResourcesMap();
    	
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        for (Map.Entry<RequestMatcher, List<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

	public void reload() throws Exception {

		LinkedHashMap<RequestMatcher, List<ConfigAttribute>> reloadedMap = getRoleAndUrlResourcesMap();

        Iterator<Entry<RequestMatcher, List<ConfigAttribute>>> iterator = reloadedMap.entrySet().iterator();

        // 이전 데이터 삭제
        requestMap.clear();

        while (iterator.hasNext()) {
        	Entry<RequestMatcher, List<ConfigAttribute>> entry = iterator.next();

            requestMap.put(entry.getKey(), entry.getValue());
        }
    }
}