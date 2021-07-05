package com.tanmoy.brainstation.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class AbstractService<T> {
	protected final static Logger LOGGER = Logger.getLogger(AbstractService.class.getName());

	public int getInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public String getBycrptPassword(String password) {
		BCryptPasswordEncoder bcryptPassword = new BCryptPasswordEncoder(12);
		return bcryptPassword.encode(password);
	}
	
	public abstract T findById(int id);

	public abstract List<T> findAll();

	public abstract boolean save(T obj);

	public abstract boolean update(T obj);

	public abstract boolean deleteById(int id);
}
