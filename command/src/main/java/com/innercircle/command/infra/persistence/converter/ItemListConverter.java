package com.innercircle.command.infra.persistence.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innercircle.command.domain.survey.item.Item;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.List;

@Converter
public class ItemListConverter implements AttributeConverter<List<Item>, String> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(List<Item> attribute) {
		try {
			return objectMapper.writeValueAsString(attribute);
		} catch (Exception e) {
			throw new RuntimeException("Failed to convert ItemInput list to JSON", e);
		}
	}

	@Override
	public List<Item> convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, new TypeReference<>() {
			});
		} catch (Exception e) {
			throw new RuntimeException("Failed to convert JSON to ItemInput list", e);
		}
	}
}
