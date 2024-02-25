package com.ssdms.core.jackson;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class PageJsonSerializer extends JsonSerializer<Page<?>> {

	@Override
	public void serialize(Page<?> page, JsonGenerator gen, SerializerProvider serializers) throws IOException {

		gen.writeStartObject();
			gen.writeObjectField("content", page.getContent());
			gen.writeObjectField("totalPages", page.getTotalPages());
			gen.writeObjectField("totalElements", page.getTotalElements());
			gen.writeObjectField("number", page.getNumber());
			gen.writeObjectField("numberOfElements", page.getNumberOfElements());
			gen.writeObjectField("size", page.getSize());
			gen.writeObjectField("first", page.isFirst());
			gen.writeObjectField("last", page.isLast());
			gen.writeObjectField("sorted", page.getSort().isSorted());	
		gen.writeEndObject();
	}

}
