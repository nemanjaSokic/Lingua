package com.lingua.config.security;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Component;

import com.lingua.service.AuthenticationService;

@EnableWebSecurity
@Component
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	@Autowired
	AuthenticationService service;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.
			authorizeRequests().
				antMatchers("/**").permitAll().
				antMatchers("/#/admin").hasRole("ADMIN").
				anyRequest().authenticated().
		and().
			formLogin().
			loginPage("/#/login").
			permitAll().
		and().
        	logout().
            deleteCookies("JSESSIONID").
            invalidateHttpSession(true).
        and().
        	httpBasic().
			authenticationEntryPoint(authEntryPoint).
		and().
			addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
				
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
			auth.userDetailsService(service);
		
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setUrl("jdbc:mysql://localhost:3306/lingua_database");
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
	    return dataSource;
	}
}
