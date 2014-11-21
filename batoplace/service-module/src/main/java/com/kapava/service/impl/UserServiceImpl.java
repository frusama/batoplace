package com.kapava.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kapava.common.bean.LabelValueBean;
import com.kapava.common.dto.UserDto;
import com.kapava.dao.entity.User;
import com.kapava.dao.jpa.UserJpa;
import com.kapava.endpoints.transformer.UserTransformer;
import com.kapava.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userJpa")
	UserJpa userJpa;

	@Resource(name="userTransformer")
	UserTransformer userTransformer;

	private static final Logger log = Logger.getLogger(UserServiceImpl.class);

	public List<UserDto> list() throws Exception {
		List<User> userList = userJpa.list();
		return userTransformer.convertFrom(userList);
	}

	public List<UserDto> list(String role) throws Exception {
		List<User> userList = userJpa.list(role);
		return userTransformer.convertFrom(userList);
	}
	
	public UserDto find(String username) throws Exception {
		User user = userJpa.find(username);
		return userTransformer.convertFrom(user);
	}

	public List<LabelValueBean> getAllRoles() throws Exception {
		List<LabelValueBean> lvbList = new ArrayList<LabelValueBean>();
		lvbList.add(new LabelValueBean("Administrator", "ROLE_ADMIN"));
		lvbList.add(new LabelValueBean("User", "ROLE_ADMIN"));
		lvbList.add(new LabelValueBean("Super User", "ROLE_ADMIN"));
		return lvbList;
	}

	public void create(UserDto userDto) throws Exception {
		userDto.setLastModified(new Date(System.currentTimeMillis()));
		User user = userTransformer.convertFrom(userDto);
		userJpa.create(user);
	}
	
	public void update(UserDto userDto) throws Exception {
		userDto.setLastModified(new Date(System.currentTimeMillis()));
		User user = userTransformer.convertFrom(userDto);
		userJpa.update(user);
	}
	
	public void delete(String username) throws Exception {
		userJpa.delete(username);
	}
	
	public void deleteAll() throws Exception {
		userJpa.deleteAll();
	}
}