package com.innercircle.command.domain.survey.item;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MultipleChoiceItem extends Item {

	private String name;
	private String description;
	private List<ItemOption> options;

	public MultipleChoiceItem(boolean required, String name, String description, List<ItemOption> options) {
		super(ItemType.MULTIPLE_CHOICE, required);
		this.name = name;
		this.description = description;
		this.options = options;
	}

	@Override
	public void validate() {

	}
}
