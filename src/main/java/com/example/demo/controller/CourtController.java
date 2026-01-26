package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CourtDTO;
import com.example.demo.service.CourtService;

@RestController
@RequestMapping("/api")
public class CourtController {
	
	@Autowired
	@Qualifier("courtService")
	private CourtService courtService;
	
	@GetMapping("/courts")
	public ResponseEntity<?> getCourts() {
		List<CourtDTO> list = courtService.listAllCourts();
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(list);
		}
	}
	
	

}
