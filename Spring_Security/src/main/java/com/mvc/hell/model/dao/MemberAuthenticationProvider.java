package com.mvc.hell.model.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mvc.hell.dto.MemberDetails;

public class MemberAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDeSer;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String)authentication.getPrincipal();//입력한 ID
		String password = (String)authentication.getCredentials();//입력한 PASSWORD
		
		MemberDetails user = (MemberDetails) userDeSer.loadUserByUsername(username);
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
		if(!matchPassword(password, user.getPassword())) {
			throw new BadCredentialsException(username);
		}
		if(!user.isEnabled()) {
			throw new BadCredentialsException(username);
		}
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user, password, authorities);
		return result; 
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;

	}
	
	private boolean matchPassword(String loginPwd, String password) {
		return loginPwd.equals(password);
	}

}
