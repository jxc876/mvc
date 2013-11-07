package com.mike.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthProvider implements AuthenticationProvider {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		String userName = auth.getPrincipal().toString();
		String password = auth.getCredentials().toString();
		
		log.debug("Request to authenticate, userName: " + userName);
		
		if (userName.equals("user") && password.equals("user")){
			UsernamePasswordAuthenticationToken token;
			token = new UsernamePasswordAuthenticationToken(userName, password, loadAuthorities());
			log.info("Authenticated Successful, userName: " + userName);
			return token;
		}
		
		log.info("Authentication Failed, userName: " + userName);
		throw new BadCredentialsException("invalid credentials"); 		
	}
	
	public Collection<GrantedAuthority> loadAuthorities(){
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(5);
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
