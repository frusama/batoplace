package com.kapava.dao.jpa;

import java.util.List;

import com.kapava.dao.entity.User;


public interface UserJpa {
	
	public List<User> list() throws Exception;
	
	public List<User> list(String role) throws Exception;
	
	public User find(String username) throws Exception;
	
	public void create(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(String username) throws Exception;
	
	public void deleteAll() throws Exception;
}