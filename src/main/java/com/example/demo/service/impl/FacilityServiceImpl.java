package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Facility;
import com.example.demo.model.FacilityDTO;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;

@Service("facilityService")
public class FacilityServiceImpl implements FacilityService{

	@Autowired
	@Qualifier("facilityRepository")
	private FacilityRepository facilityRepository;
	
	
	/**
	 * Returns all the facilities
	 */
	@Override
	public List<FacilityDTO> listAllFacilities() {
		List<FacilityDTO> facilities = new ArrayList<>();
		for(Facility f : facilityRepository.findAll())
			facilities.add(transform(f));
		return facilities;
	}

	
	/**
	 * Returns the facility by id
	 */
	@Override
	public Facility getFacilityById(int id) {
		Facility facility = new Facility();
		for(Facility f : facilityRepository.findAll())
			if(f.getId() == id)
				facility = f;
		return facility;
	}

	/**
	 * Creates a facility and returns its id
	 */
	@Override
	public int addFacility(FacilityDTO facilityDTO) {
		
		facilityRepository.save(transform(facilityDTO));
		
		return facilityDTO.getId();
	}

	/**
	 * Soft delete a facility and returns its id
	 */
	@Override
	public int deleteFacility(int id) {
		Facility facility = facilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Facility not found"));
		facility.setDeleted(true);
		facilityRepository.save(facility);
		return facility.getId();
	}

	/**
	 * Update a facility and returns its id
	 */
	@Override
	public int updateFacility(FacilityDTO facilityDTO) {
		Facility facility = facilityRepository.findById(facilityDTO.getId()).orElseThrow(() -> new RuntimeException("Facility not found"));
		facilityRepository.save(transform(facilityDTO));
		return facilityDTO.getId();
	}

	
	/**
	 * Turns the activate attribute to true
	 * and returns the facility id
	 */
	@Override
	public int activateFacility(int id) {
		Facility facility = facilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Facility not found"));
		facility.setActivated(true);
		facilityRepository.save(facility);
		return facility.getId();
	}

	/**
	 * Turns the activate attribute to false
	 * and returns the facility id
	 */
	@Override
	public int deactivateFacility(int id) {
		Facility facility = facilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Facility not found"));
		facility.setActivated(false);
		facilityRepository.save(facility);
		return facility.getId();
	}
	

	// Transform entity into model 
	private FacilityDTO transform(Facility facility) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(facility, FacilityDTO.class);
	}

	// Transform model into entity
	private Facility transform(FacilityDTO facilityDTO) {

		ModelMapper modelMapper = new ModelMapper();
		Facility facility = modelMapper.map(facilityDTO, Facility.class);

		return facility;

	}

}
