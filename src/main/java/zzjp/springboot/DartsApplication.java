package zzjp.springboot;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication(exclude = {
//		JacksonAutoConfiguration.class,
		JmxAutoConfiguration.class,
		WebSocketAutoConfiguration.class})
public class DartsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DartsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean deRegisterHiddenMethodFilter(HiddenHttpMethodFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.setEnabled(false);
		return bean;
	}

	@Bean FilterRegistrationBean deRegisterHttpPutFormContentFilter (HttpPutFormContentFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.setEnabled(false);
		return bean;
	}

	@Bean
	public FilterRegistrationBean deRegisterRequestContextFilter (RequestContextFilter requestContextFilter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(requestContextFilter);
		bean.setEnabled(false);
		return bean;
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//		builder.simpleDateFormat("yyyy");
		builder.serializationInclusion(JsonInclude.Include.NON_NULL);
		return builder;
	}




}
