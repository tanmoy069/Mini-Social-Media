package com.tanmoy.brainstation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.brainstation.domain.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{
	
	Status findByStatusId(int id);
	List<Status> findByUserIdOrderByCreatedDateDesc(String userId);
	List<Status> findByVisibilityOrderByCreatedDateDesc(int visibility);
	
}
