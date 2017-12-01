package com.lingua.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.lingua.exception.UserException;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, new UserException("You have entered an invalid username or password.\n Contact your administrator please ")
																	.getErrorMessage());
	}

	@Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("DeveloperStack");
        super.afterPropertiesSet();
    }

	
}
