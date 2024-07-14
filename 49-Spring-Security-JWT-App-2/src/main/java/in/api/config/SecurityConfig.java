package in.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import in.api.filter.JwtAuthFilter;
import in.api.repositories.UserInfoRepository;
import in.api.services.UserInfoService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	 private final JwtAuthFilter authFilter; 
	 
	 public SecurityConfig(JwtAuthFilter authFilter) { 
	        this.authFilter = authFilter; 
	 }
	 
	 @Bean
	 public UserDetailsService userDetailsService(UserInfoRepository repository, PasswordEncoder passwordEncoder) { 
	        return new UserInfoService(repository, passwordEncoder); 
	 } 
	 
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception { 
		 
		 return http
		         .authorizeHttpRequests((authz) -> authz
		             .requestMatchers("/generateToken", "/register","/h2-console").permitAll()
		             .requestMatchers("/hello").authenticated()
		         )
		         .httpBasic(Customizer.withDefaults())
		         .csrf((csrf) -> csrf.disable())
		         .sessionManagement((session) ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		         .authenticationProvider(authenticationProvider)
		         .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
		         .build();
	 }
	 
	 @Bean
	 public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		 DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		 authenticationProvider.setUserDetailsService(userDetailsService); // Gives service object to retrive data of user 
		 authenticationProvider.setPasswordEncoder(passwordEncoder);       // Gives object to find password encoding details 
		 return authenticationProvider;
	 }
	 
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception { 
	     return config.getAuthenticationManager(); 
	 } 

}
