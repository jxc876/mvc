package com.mike.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		String userName = auth.getPrincipal().toString();
		String password = auth.getCredentials().toString();
		
		if (userName.equals("user") && password.equals("user")){
			UsernamePasswordAuthenticationToken token;
			token = new UsernamePasswordAuthenticationToken(userName, password, loadAuthorities());
			return token;
		}
		
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
