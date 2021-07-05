package com.tanmoy.brainstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmoy.brainstation.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	Location findByLocationId(int id);
}
