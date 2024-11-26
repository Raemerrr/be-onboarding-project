package com.innercircle.command.domain.survey.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortTextItem extends Item {

	private static final short MAX_NAME_LENGTH = 20;
	private static final short MAX_DESCRIPTION_LENGTH = 30;
	private static final short MAX_CONTENT_LENGTH = 20;

	private String name;
	private String description;
	private String content;

	public ShortTextItem(boolean required, String name, String description, String content) {
		super(ItemType.SHORT_TEXT, required);
		this.name = name;
		this.description = description;
		this.content = content;
	}

	@Override
	public void validate() {
		var errorMessage = "Short text %s must not be empty and must not exceed %d characters";
		if (StringUtils.isBlank(name) || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(errorMessage.formatted("name", MAX_NAME_LENGTH));
		}

		if (StringUtils.isBlank(description) || description.length() > MAX_DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException(errorMessage.formatted("description", MAX_DESCRIPTION_LENGTH));
		}
	}
}
