package com.tanmoy.brainstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.brainstation.domain.User;
import com.tanmoy.brainstation.repository.UserRepository;

@Service
public class UserService extends AbstractService<User> {

	private UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User findById(int id) {
		return null;
	}

	public User findById(String id) {
		return userRepo.findByUserId(id);
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public boolean save(User obj) {
		try {
			userRepo.save(obj);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to save user id: " + obj.getUserId());
			return false;
		}
	}

	@Override
	public boolean update(User obj) {
		try {
			userRepo.save(obj);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to update user id: " + obj.getUserId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		return false;
	}

	public boolean deleteById(String id) {
		try {
			userRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to delete user id: " + id);
			return false;
		}
	}

}
