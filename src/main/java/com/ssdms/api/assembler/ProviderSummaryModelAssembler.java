package com.ssdms.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssdms.api.model.ProviderSummaryModel;
import com.ssdms.domain.model.Providers;

@Component
public class ProviderSummaryModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProviderSummaryModel toModel(Providers provider) {
		return modelMapper.map(provider, ProviderSummaryModel.class);
	}

	public List<ProviderSummaryModel> toCollectionModel(Collection<Providers> providers) {
		return providers.stream()
					.map(provider -> toModel(provider))
					.collect(Collectors.toList());
	}
}
