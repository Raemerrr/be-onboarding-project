package com.innercircle.command.application.survey;

import com.innercircle.command.domain.survey.item.Item;
import com.innercircle.command.domain.survey.item.ItemType;
import com.innercircle.command.domain.survey.item.ShortTextItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortTextItemInput extends ItemInput {

	private static final String DEFAULT_TEXT_VALUE = "";

	private String name;
	private String description;

	public ShortTextItemInput(ItemType type, boolean required, String name, String description) {
		super(type, required);
		this.name = name;
		this.description = description;
	}

	@Override
	public Item convert() {
		return new ShortTextItem(this.required, this.name, this.description, DEFAULT_TEXT_VALUE);
	}
}
