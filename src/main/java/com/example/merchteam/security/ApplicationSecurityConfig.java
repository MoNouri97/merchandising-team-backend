package com.example.merchteam.security;

import com.example.merchteam.appUser.AppUser;
import com.example.merchteam.appUser.AppUserService;
import com.example.merchteam.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtUtil jwtUtil;
	private final AppUserService<AppUser> userDetailsService;

	@Autowired
	public ApplicationSecurityConfig(AppUserService<AppUser> userDetailsService, JwtUtil jwtUtil) {
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
	}

	//this is for authorisation
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf()
			.disable()
			.cors()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)//tell spring security to use the filter 
			
			.and()
			.addFilter(new JwtAuthFilter(authenticationManager(), jwtUtil))
			.addFilterAfter(new JwtValidateFilter(jwtUtil), JwtAuthFilter.class)

			// .antMatchers("/", "/login", "/css/*", "/js/*", "/chat/**", "/resources/*")
			.authorizeRequests()
			.antMatchers("/api/**")
			.authenticated()
			.anyRequest()
			.permitAll();
	}

	//this is for authentification
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		
	}

}
