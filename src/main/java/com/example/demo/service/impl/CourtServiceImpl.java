package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Court;
import com.example.demo.model.CourtDTO;
import com.example.demo.repository.CourtRepository;
import com.example.demo.service.CourtService;

@Service("courtService")
public class CourtServiceImpl implements CourtService {

	@Autowired
	@Qualifier("courtRepository")
	private CourtRepository courtRepository;

	/**
	 * Get all Courts in database
	 */
	@Override
	public List<CourtDTO> listAllCourts() {
		List<CourtDTO> courtsDTO = new ArrayList<>();
		for (Court court : courtRepository.findAll()) {
			courtsDTO.add(transform(court));
		}
		return courtsDTO;
	}

	/**
	 * Get all courts existing in a Facility
	 */
	@Override
	public List<CourtDTO> listCourtsByFacilityId(int id) {
		List<CourtDTO> courtsDTO = new ArrayList<>();
		for (Court court : courtRepository.findByFacilityId(id)) {
			courtsDTO.add(transform(court));
		}
		return courtsDTO;
	}

	/**
	 * Get Court by Id
	 */
	@Override
	public CourtDTO getCourtById(int id) {
		CourtDTO courtDTO = transform(
				courtRepository.findById(id).orElseThrow(() -> new RuntimeException("Court not found")));
		return courtDTO;
	}

	/**
	 * Create a new Court
	 */
	@Override
	public int addCourt(CourtDTO courtDTO) {
		try {
			Court court = transform(courtDTO);
			courtRepository.save(court);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Update an existing Court
	 */
	@Override
	public int updateCourt(CourtDTO courtDTO) {
		try {
			Court court = courtRepository.findById(courtDTO.getId())
					.orElseThrow(() -> new RuntimeException("Court not found"));
			courtRepository.save(transform(courtDTO));
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Soft delete a Court
	 */
	@Override
	public int deleteCourt(int id) {
		Court court = courtRepository.findById(id).orElseThrow(() -> new RuntimeException("Court not found"));
		court.setDeleted(true);
		courtRepository.save(court);
		return 0;
	}

	/**
	 * Activate a Court
	 */
	@Override
	public int activateCourt(int id) {
		Court court = courtRepository.findById(id).orElseThrow(() -> new RuntimeException("Court not found"));
		court.setActivated(true);
		courtRepository.save(court);
		return 0;
	}

	/**
	 * Deactivate a Court
	 */
	@Override
	public int deactivateCourt(int id) {
		Court court = courtRepository.findById(id).orElseThrow(() -> new RuntimeException("Court not found"));
		court.setActivated(false);
		courtRepository.save(court);
		return 0;
	}

	// Transformar de entidad a modelo
	private CourtDTO transform(Court court) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(court, CourtDTO.class);
	}

	// Transformar de modelo a entidad
	private Court transform(CourtDTO courtDTO) {

		ModelMapper modelMapper = new ModelMapper();
		Court court = modelMapper.map(courtDTO, Court.class);

		return court;

	}

}
