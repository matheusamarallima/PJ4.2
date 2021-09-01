package com.wipro.rp.skillmng.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
		throws Exception{
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(encoder());
	}

	@Override
	protected void configure(HttpSecurity http)
			throws Exception{
		final String loginURL = "/login";
		http
				.authorizeRequests()
				.antMatchers("/css/**", "/images/**", "/javascript/**", "/forgotpassword/**",
						loginURL, "/register", "/forgotpassword")
				.permitAll()
//				.antMatchers("/**")
//					.hasAnyRole("ADMIN", "EMPLOYEE")
				.and()
				.formLogin()
				.loginPage(loginURL)
				.defaultSuccessUrl("/loginSuccess", true)
				.usernameParameter("username")
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl(loginURL);
	}
}
