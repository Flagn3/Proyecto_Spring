package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Facility;

public interface FacilityService {
	
	List<Facility> listAllFacilities();
	
	Facility getFacilityById(int id);
	
	int addFacility(Facility facility);
	
	int deleteFacility(int id);
	
	int updateFacility(Facility facility);
}
