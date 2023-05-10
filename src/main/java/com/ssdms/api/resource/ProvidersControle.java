package com.ssdms.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Providers;
import com.ssdms.domain.repository.ProvidersRepository;

@RestController
@RequestMapping("/providers")
public class ProvidersControle {

	@Autowired
	private ProvidersRepository providersRepository;
	
	@GetMapping
	public ResponseEntity<List<Providers>> list() {
		return ResponseEntity.ok(providersRepository.findAll());
	}
}
