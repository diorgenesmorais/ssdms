package com.ssdms.domain.model.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.domain.model.SupplierOrder;

@Component
public class SupplierOrderDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public SupplierOrderDTO toModel(SupplierOrder supplierOrder) {
		return modelMapper.map(supplierOrder, SupplierOrderDTO.class);
	}

	public List<SupplierOrderDTO> toCollectionModel(Collection<SupplierOrder> supplierOrder) {
		return supplierOrder.stream()
					.map(order -> toModel(order))
					.collect(Collectors.toList());
	}

}
