package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Facility;
import com.example.demo.model.FacilityDTO;

public interface FacilityService {
	
	List<FacilityDTO> listAllFacilities();
	
	Facility getFacilityById(int id);
	
	int addFacility(FacilityDTO facilityDTO);
	
	int deleteFacility(int id);
	
	int updateFacility(FacilityDTO facilityDTO);
	
	int activateFacility(int id);
	
	int deactivateFacility(int id);
}
