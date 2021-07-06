package com.tanmoy.brainstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.brainstation.domain.Status;
import com.tanmoy.brainstation.repository.StatusRepository;

@Service
public class StatusService extends AbstractService<Status> {

	private StatusRepository statusRepo;

	@Autowired
	public StatusService(StatusRepository statusRepo) {
		this.statusRepo = statusRepo;
	}

	@Override
	public Status findById(int id) {
		return statusRepo.findByStatusId(id);
	}

	@Override
	public List<Status> findAll() {
		return statusRepo.findAll();
	}
	
	public List<Status> findByUserId(String userId){
		return statusRepo.findByUserIdOrderByCreatedDateDesc(userId);
	}
	
	public List<Status> findAllPublicStatus(){
		return statusRepo.findByVisibilityOrderByCreatedDateDesc(1);
	}

	@Override
	public boolean save(Status obj) {
		try {
			statusRepo.save(obj);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to save status of user: " + obj.getUserId());
			return false;
		}
	}

	@Override
	public boolean update(Status obj) {
		try {
			statusRepo.save(obj);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to update status id: " + obj.getStatusId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			statusRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to delete status id: " + id);
			return false;
		}
	}

}
