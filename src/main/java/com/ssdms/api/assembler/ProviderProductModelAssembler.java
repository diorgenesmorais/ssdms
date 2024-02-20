package com.ssdms.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.ProviderProductsModel;
import com.ssdms.domain.model.Providers;

@Component
public class ProviderProductModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProviderProductsModel toModel(Providers provider) {
		return modelMapper.map(provider, ProviderProductsModel.class);
	}

	public List<ProviderProductsModel> toCollectionModel(Collection<Providers> providers) {
		return providers.stream()
					.map(provider -> toModel(provider))
					.collect(Collectors.toList());
	}
}
