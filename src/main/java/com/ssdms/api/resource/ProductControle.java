package com.ssdms.api.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Products;
import com.ssdms.domain.repository.ProductsRepository;
import com.ssdms.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductControle {

	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Products>> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> findById(@PathVariable String id) {
		Optional<Products> product = productsRepository.findByCodigo(id);
		return ResponseEntity.of(product);
	}
	
	@PostMapping
	public ResponseEntity<Products> save(@Valid @RequestBody Products product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}
}
