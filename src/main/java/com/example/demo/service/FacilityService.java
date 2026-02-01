package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Facility;
import com.example.demo.model.FacilityDTO;

public interface FacilityService {

	List<FacilityDTO> listAllFacilities();

	FacilityDTO getFacilityById(long id);

	void addFacility(Facility facility);

	void deleteFacility(long id);

	void updateFacility(FacilityDTO facilityDTO);

	void activateFacility(long id);

	void deactivateFacility(long id);

}
