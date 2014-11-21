package com.kapava.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kapava.common.dto.UserDto;
import com.kapava.dao.entity.User;
import com.kapava.dao.jpa.UserJpa;
import com.kapava.endpoints.transformer.UserTransformer;
import com.kapava.service.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService {

	UserJpa userJpa;

	@Resource(name="userTransformer")
	UserTransformer userTransformer;

	public void setUserJpa(UserJpa userJpa) {
		this.userJpa = userJpa;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userJpa.find(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user != null) {
			List<GrantedAuthority> authList = getAuthorities(user);
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), true, true, true, true, authList);
		}

		throw new UsernameNotFoundException("Authentication failed........");
	}

	public UserDto authenticate(String username) throws Exception {
		UserDetails userDetails = loadUserByUsername(username);
		return userTransformer.convertFrom(userDetails);
	}

	private List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
		authList.add(new SimpleGrantedAuthority(user.getRole().name()));
		return authList;
	}
}