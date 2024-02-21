package com.ssdms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.input.SupplierProductInput;
import com.ssdms.domain.model.ProviderProducts;

@Component
public class SupplierProductInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProviderProducts toDomainObject(SupplierProductInput supplierProductInput) {
		return modelMapper.map(supplierProductInput, ProviderProducts.class);
	}

	public void copyToDomainObject(SupplierProductInput supplierProductInput, ProviderProducts supplierProducts) {
		modelMapper.map(supplierProductInput, supplierProducts);
	}
}
