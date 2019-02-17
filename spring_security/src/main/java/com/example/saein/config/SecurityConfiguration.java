package com.example.saein.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity	
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/**
	 * @Author : saein
	 * @Time: 오후 8:26:59
	 * @Discription
	 *  to authenticate one by using LDAP, JDBC, Authentication Provider
	 * 
	 * @return void
	 * @throws Exception 
	
	 */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception { 
		auth
			.inMemoryAuthentication()
			.withUser("root")
			.password("root")
			.roles("USER","ADMIN");
		}
	
	
	/* (non-Javadoc)
	 * URL Security
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/","/home").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.successForwardUrl("/")
			.permitAll()
			.and()
		.logout()
			.permitAll();
			
		
	}

	
}
