package com.ssdms.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Providers;
import com.ssdms.domain.repository.ProvidersRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Fornecedores")
@RestController
@RequestMapping("/providers")
public class ProvidersController {

	@Autowired
	private ProvidersRepository providersRepository;
	
	@ApiOperation("Lista de fornecedores")
	@GetMapping
	public ResponseEntity<List<Providers>> list() {
		return ResponseEntity.ok(providersRepository.findAll());
	}
}
