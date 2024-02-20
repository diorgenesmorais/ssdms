package com.ssdms.api.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.api.assembler.ProductModelAssembler;
import com.ssdms.api.assembler.ProviderModelAssembler;
import com.ssdms.api.model.ProductModel;
import com.ssdms.api.model.ProviderModel;
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
	
	@Autowired
	private ProviderModelAssembler providerModelAssembler;
	
	@Autowired
	private ProductModelAssembler productModelAssembler;
		
	@ApiOperation("Lista de fornecedores")
	@GetMapping
	public ResponseEntity<List<ProviderModel>> list() {
		List<Providers> providers = providersRepository.findAll();
		
		return ResponseEntity.ok(providerModelAssembler.toCollectionModel(providers));
	}
	
	@ApiOperation("Obter um fornecedor")
	@GetMapping( path = "/{id}" )
	public ResponseEntity<ProviderModel> getOneProvider(@PathVariable @NonNull Integer id) {
		Optional<Providers> provider = providersRepository.findById(id);
		
		return ResponseEntity.ok(providerModelAssembler.toModel(provider.get()));
	}
	
	@ApiOperation("Obter a lista de produtos do fornecedor")
	@GetMapping("/{id}/products")
	public ResponseEntity<List<ProductModel>> findProviderWithProducts(@PathVariable @NonNull Integer id) {
		Optional<Providers> provider = providersRepository.findById(id);
		List<ProductModel> products = productModelAssembler.toCollectionModel(provider.get().getProducts());
		
		return ResponseEntity.ok(products);
	}
}
