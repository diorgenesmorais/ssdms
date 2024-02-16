package com.ssdms.api.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.api.assembler.ProductInputDisassembler;
import com.ssdms.api.assembler.ProductModelAssembler;
import com.ssdms.api.model.ProductModel;
import com.ssdms.api.model.input.ProductInput;
import com.ssdms.domain.model.Products;
import com.ssdms.domain.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produtos")
@RestController
@RequestMapping(value =  "/products", produces = MediaType.APPLICATION_JSON_VALUE )
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductModelAssembler productModalAssembler;
	
	@Autowired
	private ProductInputDisassembler productInputDisassembler;

	@ApiOperation("Lista de produtos")
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAll() {
		var products = productService.getAll();

		return ResponseEntity.ok(productModalAssembler.toCollectionModel(products));
	}
	
	@SuppressWarnings("null")
	@ApiOperation("Obter um produto por seu identificador")
	@GetMapping( path = "/{id}" )
	public ResponseEntity<ProductModel> findById(@PathVariable String id) {
		Optional<Products> product = Optional.of(productService.fetchByCodigo(id));
		
		Optional<ProductModel> productModel = Optional.of(productModalAssembler.toModel(product.get()));
		return ResponseEntity.of(productModel);
	}

	@ApiOperation("Adicionar um produto")
	@PostMapping
	public ResponseEntity<ProductModel> save(@Valid @RequestBody @NonNull ProductInput productInput) {
		
		Products product = productInputDisassembler.toDomainObject(productInput);
		@SuppressWarnings("null")
		Optional<Products> productSave = Optional.of(productService.save(product));

		ProductModel productModel = productModalAssembler.toModel(productSave.get());

		return ResponseEntity.status(HttpStatus.CREATED).body(productModel);
	}

	@ApiOperation("Filtra produtos por descrição")
	@GetMapping(value = "/for-description")
	public ResponseEntity<List<ProductModel>> filterByDescription(String description) {
		List<Products> products = productService.filterByDescription(description);
		
		List<ProductModel> productList = productModalAssembler.toCollectionModel(products);

		return ResponseEntity.ok(productList);
	}

}
