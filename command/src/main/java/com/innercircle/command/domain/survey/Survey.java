package com.innercircle.command.domain.survey;

import com.innercircle.command.domain.survey.item.Item;
import com.innercircle.command.infra.persistence.converter.ItemListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey {

	@Id
	private UUID id;
	private String name;
	private String description;
	@Lob
	@Convert(converter = ItemListConverter.class)
	private List<Item> items;

	public Survey(UUID id, String name, String description, List<Item> items) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.items = items;
	}
}
