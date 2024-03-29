package com.ssdms.api.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.api.assembler.ProductModelAssembler;
import com.ssdms.api.assembler.ProductProviderModelAssembler;
import com.ssdms.api.assembler.ProviderSummaryModelAssembler;
import com.ssdms.api.assembler.ProviderFullModelAssembler;
import com.ssdms.api.model.ProductModel;
import com.ssdms.api.model.ProductProviderModel;
import com.ssdms.api.model.ProviderSummaryModel;
import com.ssdms.api.model.ProviderFullModel;
import com.ssdms.api.model.input.SupplierProductInput;
import com.ssdms.domain.model.ProviderProducts;
import com.ssdms.domain.model.Providers;
import com.ssdms.domain.repository.ProvidersRepository;
import com.ssdms.domain.service.ProviderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Fornecedores")
@RestController
@RequestMapping("/providers")
public class ProvidersController {

	@Autowired
	private ProvidersRepository providersRepository;
	
	@Autowired
	private ProviderSummaryModelAssembler providerModelAssembler;
	
	@Autowired
	private ProductModelAssembler productModelAssembler;
	
	@Autowired
	private ProviderFullModelAssembler providerFullModelAssembler;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ProductProviderModelAssembler productProviderModelAssembler;
		
	@ApiOperation("Lista de fornecedores")
	@GetMapping
	public ResponseEntity<List<ProviderSummaryModel>> list() {
		List<Providers> providers = providersRepository.findAll();
		
		return ResponseEntity.ok(providerModelAssembler.toCollectionModel(providers));
	}
	
	@ApiOperation("Obter um fornecedor")
	@GetMapping( path = "/{id}" )
	public ResponseEntity<ProviderFullModel> getOneProvider(@PathVariable @NonNull Integer id) {
		Optional<Providers> provider = providersRepository.findById(id);
		
		return ResponseEntity.ok(providerFullModelAssembler.toModel(provider.get()));
	}
	
	@ApiOperation("Obter a lista de produtos do fornecedor")
	@GetMapping("/{id}/products")
	public ResponseEntity<List<ProductModel>> findProviderWithProducts(@PathVariable @NonNull Integer id) {
		Optional<Providers> provider = providersRepository.findById(id);
		List<ProductModel> products = productModelAssembler.toCollectionModel(provider.get().getProducts());
		
		return ResponseEntity.ok(products);
	}

	@PutMapping("/{id}/products/{productId}/associate")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void associateProduct(@PathVariable @NonNull Integer id, 
			@PathVariable @NonNull Integer productId, @RequestBody @Valid SupplierProductInput supplierProductInput) {
		providerService.associateProducts(id, productId, supplierProductInput);
	}
	
	@PutMapping("/{id}/products/{productId}/disassociate")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void disassociateProduct(@PathVariable @NonNull Integer id, @PathVariable @NonNull Integer productId) {
		providerService.disassociateProducts(id, productId);
	}

	@GetMapping("/{providerId}/products/{productId}")
	public ResponseEntity<ProductProviderModel> fetchProviderProduct(@PathVariable @NonNull Integer providerId, 
			@PathVariable @NonNull Integer productId) {
		Optional<ProviderProducts> providerProducts = providerService.fetchByProviderProduct(providerId, productId);
		ProductProviderModel productProviderModel = productProviderModelAssembler.toModel(providerProducts.get());

		return ResponseEntity.ok(productProviderModel);
	}
}
