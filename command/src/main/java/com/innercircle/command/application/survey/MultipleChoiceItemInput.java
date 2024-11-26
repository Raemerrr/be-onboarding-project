package com.innercircle.command.application.survey;

import com.innercircle.command.domain.survey.item.Item;
import com.innercircle.command.domain.survey.item.ItemOption;
import com.innercircle.command.domain.survey.item.ItemType;
import com.innercircle.command.domain.survey.item.MultipleChoiceItem;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MultipleChoiceItemInput extends ItemInput {

	private String name;
	private String description;
	private List<String> optionNames;

	public MultipleChoiceItemInput(ItemType type, boolean required, String name, String description, List<String> optionNames) {
		super(type, required);
		this.name = name;
		this.description = description;
		this.optionNames = optionNames;
	}

	@Override
	public Item convert() {
		var options = optionNames.stream()
				.map(optionName -> new ItemOption(optionName, false))
				.toList();
		return new MultipleChoiceItem(this.required, this.name, this.description, options);
	}
}
