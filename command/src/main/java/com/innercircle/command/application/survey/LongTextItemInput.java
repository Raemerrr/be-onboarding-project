package com.innercircle.command.application.survey;

import com.innercircle.command.domain.survey.item.Item;
import com.innercircle.command.domain.survey.item.ItemType;
import com.innercircle.command.domain.survey.item.LongTextItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LongTextItemInput extends ItemInput {

	private static final String DEFAULT_TEXT_VALUE = "";

	private String name;
	private String description;

	public LongTextItemInput(ItemType type, boolean required, String name, String description) {
		super(type, required);
		this.name = name;
		this.description = description;
	}

	@Override
	public Item convert() {
		return new LongTextItem(this.required, this.name, this.description, DEFAULT_TEXT_VALUE);
	}
}
