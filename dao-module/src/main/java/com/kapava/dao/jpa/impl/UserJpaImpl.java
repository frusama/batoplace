package com.kapava.dao.jpa.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.kapava.dao.entity.User;
import com.kapava.dao.jpa.UserJpa;

@Transactional
public class UserJpaImpl implements UserJpa {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<User> list() throws Exception {
		String sql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		
		List<User> result = (List<User>)query.list();
		if (result != null && result.size() > 0){
			return result;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> list(String role) throws Exception {
		String sql = "from User where role = :userRole";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("userRole", role);
		
		List<User> result = (List<User>)query.list();
		if (result != null && result.size() > 0){
			return result;
		}
		return null;
	}

	public User find(String username) throws Exception {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where userName = :userName");
		query.setParameter("userName", username);

		User result = (User)query.uniqueResult();

		return result;
	}

	public void create(User user) throws Exception {
		sessionFactory.getCurrentSession().save(user);
	}

	public void update(User user) throws Exception {
		sessionFactory.getCurrentSession().update(user);
	}

	public void delete(String username) throws Exception {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(User.class, username));
	}

	public void deleteAll() throws Exception {
		
	}
}