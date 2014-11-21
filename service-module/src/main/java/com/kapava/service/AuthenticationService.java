package com.kapava.service;

import com.kapava.common.dto.UserDto;

public interface AuthenticationService {

	public UserDto authenticate(String username) throws Exception;

}