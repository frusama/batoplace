package com.kapava.endpoints.transformer;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.kapava.common.dto.UserDto;
import com.kapava.dao.entity.User;

public interface UserTransformer {

	public UserDto convertFrom(User user) throws Exception;

	public UserDto convertFrom(UserDetails userDetails) throws Exception;

	public User convertFrom(UserDto userDto) throws Exception;

	public List<UserDto> convertFrom(List<User> userList) throws Exception;

}
