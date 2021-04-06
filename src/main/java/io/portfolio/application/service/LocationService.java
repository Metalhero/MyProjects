package io.portfolio.application.service;

import io.portfolio.application.domain.Location;
import io.portfolio.application.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {


    LocationRepository locationRepository;

    @Autowired
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public void save(Location location) {
        locationRepository.save(location);
    }

    public Location findById(Long id) {
        return locationRepository.findById(id).get();
    }

    public void delete(Long id) {
        locationRepository.deleteById(id);
    }

}