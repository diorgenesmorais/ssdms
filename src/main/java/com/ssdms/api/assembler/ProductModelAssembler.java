package com.ssdms.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.ProductModel;
import com.ssdms.domain.model.Products;

@Component
public class ProductModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProductModel toModel(Products product) {
		return modelMapper.map(product, ProductModel.class);
	}

	public List<ProductModel> toCollectionModel(Collection<Products> products) {
		return products.stream()
					.map(product -> toModel(product))
					.collect(Collectors.toList());
	}

	public Page<ProductModel> toListPage(Page<Products> products) {
		return products.map(product -> toModel(product));
	}
}
