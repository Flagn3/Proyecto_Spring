package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Court;
import com.example.demo.model.CourtDTO;

public interface CourtService {

	List<CourtDTO> listAllCourts();

	List<CourtDTO> listCourtsByFacilityId(int id);

	CourtDTO getCourtById(int id);

	int addCourt(CourtDTO courtDTO);

	int updateCourt(CourtDTO courtDTO);

	int deleteCourt(int id);
	
	int activateCourt(int id);
	
	int deactivateCourt(int id);

}
