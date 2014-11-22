package com.kapava.endpoints.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kapava.common.bean.DTableData;
import com.kapava.common.dto.UserDto;
import com.kapava.common.enums.UserRole;
import com.kapava.dao.entity.User;
import com.kapava.endpoints.transformer.UserTransformer;

@Service("userTransformer")
public class UserTransformerImpl implements UserTransformer {

	public UserDto convertFrom(User user) throws Exception {
		UserDto userDto = new UserDto();

		userDto.setAccountNonExpired(userDto.isAccountNonExpired());
		userDto.setAccountNonLocked(userDto.isAccountNonLocked());
		userDto.setCredentialsNonExpired(userDto.isCredentialsNonExpired());
		userDto.setEmailAddress(user.getEmailAddress());
		userDto.setEnabled(userDto.isEnabled());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastModified(user.getLastModified());
		userDto.setLastName(user.getLastName());
		userDto.setMiddleName(user.getMiddleName());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setRole(user.getRole());
		userDto.setUserName(user.getUserName());
		userDto.setUserPassword(user.getUserPassword());

		return userDto;
	}

	public UserDto convertFrom(UserDetails userDetails) throws Exception {
		UserDto userDto = new UserDto();
		userDto.setUserName(userDetails.getUsername());
		userDto.setRole(UserRole.valueOf(userDetails.getAuthorities().toString()));
		return userDto;		
	}

	public User convertFrom(UserDto userDto) throws Exception {
		User user = new User();

		user.setAccountNonExpired(userDto.isAccountNonExpired());
		user.setAccountNonLocked(userDto.isAccountNonLocked());
		user.setCredentialsNonExpired(userDto.isCredentialsNonExpired());
		user.setEmailAddress(userDto.getEmailAddress());
		user.setEnabled(userDto.isEnabled());
		user.setFirstName(userDto.getFirstName());
		user.setLastModified(userDto.getLastModified());
		user.setLastName(userDto.getLastName());
		user.setMiddleName(userDto.getMiddleName());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setRole(userDto.getRole());
		user.setUserName(userDto.getUserName());
		user.setUserPassword(userDto.getUserPassword());

		return user;
	}

	public List<UserDto> convertFrom(List<User> userList) throws Exception {
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for (User user : userList) {
			userDtoList.add(convertFrom(user));
		}
		return userDtoList;
	}

	public String toJson(List<UserDto> userDtoList) throws Exception {
		DTableData<UserDto> dTableData = new DTableData<UserDto>();
		dTableData.set(userDtoList);

		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy hh:mm aaa").create();
		String jsonString = gson.toJson(dTableData);

		return jsonString;
	}
}