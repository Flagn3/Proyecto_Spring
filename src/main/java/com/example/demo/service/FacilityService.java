package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Facility;
import com.example.demo.model.FacilityDTO;

public interface FacilityService {
	
	List<FacilityDTO> listAllFacilities();
	
	Facility getFacilityById(int id);
	
	int addFacility(FacilityDTO facilityDTO);
	
	Long deleteFacility(int id);
	
	int updateFacility(FacilityDTO facilityDTO);
	
	Long activateFacility(int id);
	
	Long deactivateFacility(int id);
}
