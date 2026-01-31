package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Facility;
import com.example.demo.model.FacilityDTO;

public interface FacilityService {
	
	List<FacilityDTO> listAllFacilities();
	
	Facility getFacilityById(long id);
	
	int addFacility(FacilityDTO facilityDTO);
	
	long deleteFacility(long id);
	
	int updateFacility(FacilityDTO facilityDTO);
	
	long activateFacility(long id);
	
	long deactivateFacility(long id);
}
