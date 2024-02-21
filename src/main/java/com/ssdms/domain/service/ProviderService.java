package com.ssdms.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.dms.useful.exception.EntityNotFoundException;
import com.ssdms.api.assembler.SupplierProductInputDisassembler;
import com.ssdms.api.model.input.SupplierProductInput;
import com.ssdms.domain.model.Products;
import com.ssdms.domain.model.SupplierKeyId;
import com.ssdms.domain.model.ProviderProducts;
import com.ssdms.domain.model.Providers;
import com.ssdms.domain.repository.ProvidersRepository;
import com.ssdms.domain.repository.SupplierProductsRepository;

@Service
public class ProviderService {

	@Autowired
	private ProvidersRepository providersRepository;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierProductInputDisassembler supplierProductInputDisassembler;
	
	@Autowired
	private SupplierProductsRepository supplierProductsRepository;

	public Providers fetchById(@NonNull Integer id) {
		return providersRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("O %s id não retornou um fornecedor", id)));
	}

	@SuppressWarnings("null")
	@Transactional
	public ProviderProducts saveSupplierProduct(SupplierProductInput supplierProductInput) {
		ProviderProducts supplierProduct = supplierProductInputDisassembler.toDomainObject(supplierProductInput);
		return supplierProductsRepository.save(supplierProduct);
	}
	
	public Optional<ProviderProducts> fetchByProviderProduct(@NonNull Integer providerId, @NonNull Integer productId) {
		return supplierProductsRepository.findByProviderIdAndProductId(providerId, productId);
	}

	@Transactional
	public void deleteSupplierProduct(@NonNull ProviderProducts providerProducts) {
		supplierProductsRepository.delete(providerProducts);			
	}

	@Transactional
	public void associateProducts(@NonNull Integer providerId, @NonNull Integer productId, SupplierProductInput supplierProduct) {
		Providers provider = this.fetchById(providerId);
		Products product = productService.fetchById(productId);

		SupplierKeyId providerProductId = new SupplierKeyId();
		providerProductId.setProviderId(provider.getId());
		providerProductId.setProductId(product.getId());
		supplierProduct.setProviderProductId(providerProductId);
		
		saveSupplierProduct(supplierProduct);
	}

	@Transactional
	public void disassociateProducts(@NonNull Integer providerId, @NonNull Integer productId) {
		ProviderProducts providerProducts = new ProviderProducts(providerId, productId);
		
		deleteSupplierProduct(providerProducts);			
	}
}
