package com.kapava.service;

import java.util.List;

import com.kapava.common.bean.LabelValueBean;
import com.kapava.common.dto.UserDto;

public interface UserService {
	
	public List<UserDto> list() throws Exception;

	public String jsonUserDtoList() throws Exception;
	
	public List<UserDto> list(String role) throws Exception;
	
	public UserDto find(String username) throws Exception;

	public List<LabelValueBean> getAllRoles() throws Exception;
	
	public void create(UserDto user) throws Exception;
	
	public void update(UserDto user) throws Exception;
	
	public void delete(String username) throws Exception;
	
	public void deleteAll() throws Exception;

}