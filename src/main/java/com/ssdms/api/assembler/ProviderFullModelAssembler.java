package com.ssdms.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.ProviderFullModel;
import com.ssdms.domain.model.Providers;

@Component
public class ProviderFullModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProviderFullModel toModel(Providers provider) {
		return modelMapper.map(provider, ProviderFullModel.class);
	}

	public List<ProviderFullModel> toCollectionModel(Collection<Providers> providers) {
		return providers.stream()
					.map(provider -> toModel(provider))
					.collect(Collectors.toList());
	}
}
