package com.ssdms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.ProductProviderModel;
import com.ssdms.domain.model.ProviderProducts;

@Component
public class ProductProviderModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProductProviderModel toModel(ProviderProducts provider) {
		return modelMapper.map(provider, ProductProviderModel.class);
	}

}
