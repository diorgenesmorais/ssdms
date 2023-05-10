package com.ssdms.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.SupplierProducts;
import com.ssdms.domain.repository.SupplierProductsRepository;

@RestController
@RequestMapping("/supplier")
public class SupplierProductsControle {

	@Autowired
	private SupplierProductsRepository supplierProductsRepository;
	
	@GetMapping
	public ResponseEntity<List<SupplierProducts>> list() {
		return ResponseEntity.ok(supplierProductsRepository.findAll());
	}
}
