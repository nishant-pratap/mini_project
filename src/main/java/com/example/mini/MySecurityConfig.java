package com.example.mini;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
// @formatter:off
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	// Define your users and their roles here
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("admin").password(encoder.encode("admin111"))
				.roles("ADMIN", "USER").and().withUser("user").password(encoder.encode("user111")).roles("USER");
	}

	// Define which paths are accessible to which roles here
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().and().authorizeRequests().antMatchers("/api/create/**")

				.hasRole("ADMIN").antMatchers("/api/**").permitAll().antMatchers("/**").hasRole("USER").and().csrf()
				.disable().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	}

}