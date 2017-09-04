package spring.web.config.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.Controller;

@Configuration
@ComponentScan(
	basePackages = "spring.web", 
	excludeFilters = {
		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Controller.class)
	}, 
	includeFilters = { 
		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Service.class),
		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Repository.class)
	}
)
public class CommonConfig {
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource msg = new ReloadableResourceBundleMessageSource();
		msg.setBasename("classpath:messages/message");
		msg.setDefaultEncoding("UTF-8");
		return msg;
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
}
