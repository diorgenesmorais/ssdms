package com.ssdms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.input.ProductInput;
import com.ssdms.domain.model.Category;
import com.ssdms.domain.model.Products;
import com.ssdms.domain.model.Unit;

@Component
public class ProductInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Products toDomainObject(ProductInput productInput) {
		return modelMapper.map(productInput, Products.class);
	}
	
	public void copyToDomainObject(ProductInput productInput, Products product) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of 
		// com.ssdms.domain.model.Cotegory was altered from 1 to 2
		product.setCategory(new Category());
		product.setUnit(new Unit());

		modelMapper.map(productInput, product);
	}
}
