package com.tanmoy.brainstation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmoy.brainstation.domain.Location;
import com.tanmoy.brainstation.repository.LocationRepository;

@Service
public class LocationService extends AbstractService<Location> {

	private LocationRepository locRepo;

	@Autowired
	public LocationService(LocationRepository locRepo) {
		this.locRepo = locRepo;
	}

	@Override
	public Location findById(int id) {
		return locRepo.findByLocationId(id);
	}

	@Override
	public List<Location> findAll() {
		return locRepo.findAll();
	}

	@Override
	public boolean save(Location obj) {
		try {
			locRepo.save(obj);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to save location: " + obj.getLocationName());
			return false;
		}
	}

	@Override
	public boolean update(Location obj) {
		try {
			locRepo.save(obj);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to update location id: " + obj.getLocationId());
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			locRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to delete location id: " + id);
			return false;
		}
	}
}
