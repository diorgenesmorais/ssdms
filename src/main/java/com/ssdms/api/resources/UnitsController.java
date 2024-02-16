package com.ssdms.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Unit;
import com.ssdms.domain.repository.UnitsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Unidades")
@RestController
@RequestMapping("/units")
public class UnitsController {

	@Autowired
	private UnitsRepository unitsRepository;
	
	@ApiOperation("detalhes das unidades")
	@GetMapping
	public ResponseEntity<List<Unit>> list() {
		return ResponseEntity.ok(unitsRepository.findAll());
	}
}
