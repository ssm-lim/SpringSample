package spring.web.app.system.security.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class RoleAndUrlResourcesMapLoader {
	
	@Autowired
	SecurityService securityService;
	
	/**
	 * ROLE의 계층 리스트를 가져온다.
	 * 
	 * @return URL과 ROLE의 매핑 리스트를 가져온다.
	 */
	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRoleAndUrlResourcesMap() {
		List<Map<String, Object>> resultList = securityService.getRolesAndUrl();
		return patchRequestMatcher(makeResourceMap(resultList));
	}
	
	
	/**
	 * makeLinkedHashMap의 결과 데이터에서 Object key를 RequestMatcher로 캐스팅한다.
	 * 
	 * @param data LinkedHashMap으로 변환된 데이터
	 * @return 리턴값 설명
	 */
	private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> patchRequestMatcher(LinkedHashMap<Object, List<ConfigAttribute>> data) {
		LinkedHashMap<RequestMatcher, List<ConfigAttribute>> ret = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();
		Set<Object> keys = data.keySet();
		
		for (Object key : keys) {
			ret.put((RequestMatcher) key, data.get(key));
		}
		return ret;
	}
	
	/**
     * 리소스 유형에 대한 할당된 롤 정보를 가져온다.
     *
     * @param resourceType
     * @return
     * @throws Exception
     */
	private LinkedHashMap<Object, List<ConfigAttribute>> makeResourceMap(List<Map<String, Object>> list) {

		String resourceType = "url";
		String authorityStr = "accessRole";
		
		Map<String, Object> tempMap;
        String preResource = null;
        String presentResourceStr;
        Object presentResource;
	
		LinkedHashMap<Object, List<ConfigAttribute>> resourcesMap = new LinkedHashMap<Object, List<ConfigAttribute>>();
      
		Iterator<Map<String, Object>> itr = list.iterator();
        while (itr.hasNext()) {
            tempMap = itr.next();

            presentResourceStr = (String) tempMap.get(resourceType);
            
            presentResource = new AntPathRequestMatcher(presentResourceStr);
            
            List<ConfigAttribute> configList = new LinkedList<ConfigAttribute>();

            // 이미 requestMap 에 해당 Resource 에 대한 Role 이 하나 이상 맵핑되어 있었던 경우,
            // sort_order 는 resource(Resource) 에 대해 매겨지므로 같은 Resource 에 대한 Role 맵핑은 연속으로 조회됨.
            // 해당 맵핑 Role List (SecurityConfig) 의 데이터를 재활용하여 새롭게 데이터 구축
            if (preResource != null && presentResourceStr.equals(preResource)) {
                List<ConfigAttribute> preAuthList = resourcesMap.get(presentResource);
                Iterator<ConfigAttribute> preAuthItr = preAuthList.iterator();
                while (preAuthItr.hasNext()) {
                    SecurityConfig tempConfig = (SecurityConfig) preAuthItr.next();
                    configList.add(tempConfig);
                }
            }

            configList.add(new SecurityConfig((String) tempMap.get(authorityStr)));

            // 만약 동일한 Resource 에 대해 한개 이상의 Role 맵핑 추가인 경우
            // 이전 resourceKey 에 현재 새로 계산된 Role 맵핑 리스트로 덮어쓰게 됨.
            resourcesMap.put(presentResource, configList);

            // 이전 resource 비교위해 저장
            preResource = presentResourceStr;
        }
        return resourcesMap;
	}
}
