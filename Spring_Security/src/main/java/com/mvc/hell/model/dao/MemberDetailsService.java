package com.mvc.hell.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mvc.hell.dto.MemberDetails;

public class MemberDetailsService implements UserDetailsService {

	@Autowired
	private MemberAuthDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDetails user = dao.login(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

}
