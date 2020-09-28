package cl.mineduc.sismologia.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import cl.mineduc.sismologia.api.security.JWTAuthorizationFilter;
import org.h2.server.web.WebServlet;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"cl.mineduc.sismologia"})
@EntityScan("cl.mineduc.sismologia.models.entity")
@EnableJpaRepositories("cl.mineduc.sismologia.models.dao")
public class SismoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SismoProjectApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("cl.mineduc.sismologia.api")).paths(PathSelectors.any())
				.build();
	}
	
	/**
	 * Administrador H2
	 * @return
	 */
	@Bean
	ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
	        registrationBean.addUrlMappings("/console/*");
	        return registrationBean;
	}
	 
//
//	@EnableWebSecurity
//	@Configuration
//	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable()
//					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//					.authorizeRequests().antMatchers(HttpMethod.POST, "/user").permitAll().anyRequest().authenticated();
//		}
//	}

}
