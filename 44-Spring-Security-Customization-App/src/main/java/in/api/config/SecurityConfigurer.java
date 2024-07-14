package in.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
		// logic tp customized security in our app
		
		http.authorizeHttpRequests(request -> request.requestMatchers("/login","/contact","/swagger-ui.html").permitAll()
													 .anyRequest().authenticated()
					)
			.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.httpBasic(Customizer.withDefaults());
		return http.build();
		 
	}
	

}
