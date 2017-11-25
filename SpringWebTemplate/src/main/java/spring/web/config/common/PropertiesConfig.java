package spring.web.config.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class PropertiesConfig {
	// https://slipp.net/wiki/pages/viewpage.action?pageId=22282248
	// http://kwonnam.pe.kr/wiki/springframework/propertysource
	// http://goodcodes.tistory.com/entry/Spring-Java-Config-Properties
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
}
