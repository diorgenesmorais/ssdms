package com.ssdms.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.ProviderModel;
import com.ssdms.domain.model.Providers;

@Component
public class ProviderModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProviderModel toModel(Providers provider) {
		return modelMapper.map(provider, ProviderModel.class);
	}

	public List<ProviderModel> toCollectionModel(Collection<Providers> providers) {
		return providers.stream()
					.map(product -> toModel(product))
					.collect(Collectors.toList());
	}
}
