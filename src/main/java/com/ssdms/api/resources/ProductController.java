package com.ssdms.api.resources;

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
import com.ssdms.domain.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produtos")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation("Lista de produtos")
	@GetMapping
	public ResponseEntity<List<Products>> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}
	
	@ApiOperation("Obter um produto por seu identificador")
	@GetMapping("/{id}")
	public ResponseEntity<Products> findById(@PathVariable String id) {
		Optional<Products> product = productService.fetchByCodigo(id);
		return ResponseEntity.of(product);
	}
	
	@ApiOperation("Adicionar um produto")
	@PostMapping
	public ResponseEntity<Products> save(@Valid @RequestBody Products product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}

	@ApiOperation("Filtra produtos por descrição")
	@GetMapping("/for-description")
	public ResponseEntity<List<Products>> filterByDescription(String description) {
		return ResponseEntity.ok(productService.filterByDescription(description));
	}
}
