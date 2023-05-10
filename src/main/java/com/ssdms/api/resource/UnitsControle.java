package com.ssdms.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Units;
import com.ssdms.domain.repository.UnitsRepository;

@RestController
@RequestMapping("/units")
public class UnitsControle {

	@Autowired
	private UnitsRepository unitsRepository;
	
	@GetMapping
	public ResponseEntity<List<Units>> list() {
		return ResponseEntity.ok(unitsRepository.findAll());
	}
}
