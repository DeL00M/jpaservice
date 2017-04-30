package ru.deloom.jpaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("ru.deloom.jpaservice")
@EnableJpaRepositories("ru.deloom.jpaservice.repositories")
public class JpaserviceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(JpaserviceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JpaserviceApplication.class) ;
	}
}
