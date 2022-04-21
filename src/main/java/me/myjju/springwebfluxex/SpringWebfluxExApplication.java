package me.myjju.springwebfluxex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = MongoReactiveAutoConfiguration.class)
public class SpringWebfluxExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxExApplication.class, args);
	}

//	@Bean
//	public SecurityWebFilterChain functionalValidationsSpringSecurityFilterChain(ServerHttpSecurity http) {
//		http.authorizeExchange()
//				.anyExchange()
//				.permitAll();
//		http.csrf().disable();
//		return http.build();
//	}
}
