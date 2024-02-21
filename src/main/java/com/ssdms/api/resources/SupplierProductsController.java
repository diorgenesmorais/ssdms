package com.ssdms.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.ProviderProducts;
import com.ssdms.domain.repository.SupplierProductsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produtos por fornecedor")
@RestController
@RequestMapping("/supplier-products")
public class SupplierProductsController {

//	@Autowired
//	private SupplierProductsRepository supplierProductsRepository;
//	
//	@ApiOperation("Lista dos produtos por fornecedor")
//	@GetMapping
//	public ResponseEntity<List<ProviderProducts>> list() {
//		return ResponseEntity.ok(supplierProductsRepository.findAll());
//	}
}
