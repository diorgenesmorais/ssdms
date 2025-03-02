package com.ssdms.api.resources;

import com.ssdms.api.assembler.ProductModelAssembler;
import com.ssdms.api.assembler.ProductProviderModelAssembler;
import com.ssdms.api.assembler.ProviderSummaryModelAssembler;
import com.ssdms.api.model.ProductModel;
import com.ssdms.api.model.ProductProviderModel;
import com.ssdms.api.model.ProviderSummaryModel;
import com.ssdms.api.model.input.SupplierProductInput;
import com.ssdms.domain.model.ProviderProducts;
import com.ssdms.domain.model.Providers;
import com.ssdms.domain.service.ProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(tags = "Fornecedores")
@RestController
@RequestMapping("/providers")
public class ProvidersController {

	private final ProviderSummaryModelAssembler providerModelAssembler;
	private final ProductModelAssembler productModelAssembler;
	private final ProviderService providerService;
	private final ProductProviderModelAssembler productProviderModelAssembler;

	public ProvidersController(ProviderSummaryModelAssembler providerModelAssembler, ProductModelAssembler productModelAssembler,
							   ProviderService providerService, ProductProviderModelAssembler productProviderModelAssembler) {
		this.providerModelAssembler = providerModelAssembler;
		this.productModelAssembler = productModelAssembler;
		this.providerService = providerService;
		this.productProviderModelAssembler = productProviderModelAssembler;
	}

	@ApiOperation("Lista de fornecedores")
	@GetMapping
	public ResponseEntity<List<ProviderSummaryModel>> list() {
		List<Providers> providers = providerService.fetchAll();
		
		return ResponseEntity.ok(providerModelAssembler.toCollectionModel(providers));
	}
	
	@ApiOperation("Obter um fornecedor")
	@GetMapping( path = "/{id}" )
	public ResponseEntity<ProviderSummaryModel> getOneProvider(@PathVariable @NonNull Integer id) {
	    Providers provider = providerService.fetchById(id);
		
		return ResponseEntity.ok(providerModelAssembler.toModel(provider));
	}

	@ApiOperation("Obter a lista de produtos do fornecedor")
	@GetMapping("/{id}/products")
	public ResponseEntity<List<ProductModel>> findProviderWithProducts(@PathVariable @NonNull Integer id) {
		Providers provider = providerService.fetchById(id);
		List<ProductModel> products = productModelAssembler.toCollectionModel(provider.getProducts());
		
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
