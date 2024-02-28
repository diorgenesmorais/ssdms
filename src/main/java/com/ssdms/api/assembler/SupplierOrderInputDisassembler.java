package com.ssdms.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.input.SupplierOrderInput;
import com.ssdms.domain.model.SupplierOrder;

@Component
public class SupplierOrderInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public SupplierOrder toDomainObject(SupplierOrderInput supplierOrderInput) {
		return modelMapper.map(supplierOrderInput, SupplierOrder.class);
	}

	public void copyToDomainObject(SupplierOrderInput supplierOrderInput, SupplierOrder supplierOrder) {
		modelMapper.map(supplierOrderInput, supplierOrder);
	}
}
