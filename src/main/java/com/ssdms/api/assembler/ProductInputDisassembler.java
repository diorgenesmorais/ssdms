package com.ssdms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.input.ProductInput;
import com.ssdms.domain.model.Products;

@Component
public class ProductInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Products toDomainObject(ProductInput productInput) {
		return modelMapper.map(productInput, Products.class);
	}
}
