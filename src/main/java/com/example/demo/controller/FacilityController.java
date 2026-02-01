package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Facility;
import com.example.demo.model.FacilityDTO;
import com.example.demo.model.ResponseAPI;
import com.example.demo.service.FacilityService;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

	@Autowired
	@Qualifier("facilityService")
	private FacilityService facilityService;
	
	@GetMapping
	public ResponseEntity<?> getAllFacilities(){
		List<FacilityDTO> facilities = facilityService.listAllFacilities();
		return ResponseEntity.ok(new ResponseAPI<>(true, facilities, "Facilities retrieved succesfully"));
	}
	
	@GetMapping("/getFacility/{id}")
	public ResponseEntity<?> getFacilityById(@PathVariable int id){
		try {
			FacilityDTO facilityDTO = facilityService.getFacilityById(id);
			return ResponseEntity.ok(new ResponseAPI<>(true, facilityDTO, "Facility retrieved succesfully"));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseAPI<>(false, null, e.getMessage()));
		}
	}
	
	@PostMapping("/addFacility")
	public ResponseEntity<?> addFacility(@ModelAttribute Facility facility){
		
		facilityService.addFacility(facility);
		return ResponseEntity.ok(new ResponseAPI<>(true, facility, "Facility added succesfully"));
		
	}
	
	@DeleteMapping("/deleteFacility/{id}")
	public ResponseEntity<?> deleteFaciliy(@PathVariable long id){
		
		try {
			facilityService.deleteFacility(id);
			return ResponseEntity.ok(new ResponseAPI<>(true, facilityService.getFacilityById(id), "Facility added succesfully"));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseAPI<>(false, null, e.getMessage()));
		}
	}
	
	
}
