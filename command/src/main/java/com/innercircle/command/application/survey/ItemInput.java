package com.innercircle.command.application.survey;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.innercircle.command.domain.survey.item.Item;
import com.innercircle.command.domain.survey.item.ItemType;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = As.EXISTING_PROPERTY,
		property = "type",
		visible = true
)
@JsonSubTypes({
		@Type(value = ShortTextItemInput.class, name = "SHORT_TEXT"),
		@Type(value = LongTextItemInput.class, name = "LONG_TEXT"),
		@Type(value = SingleChoiceItemInput.class, name = "SINGLE_CHOICE"),
		@Type(value = MultipleChoiceItemInput.class, name = "MULTIPLE_CHOICE"),
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ItemInput implements Serializable {

	protected ItemType type;
	protected boolean required;

	protected ItemInput(ItemType type, boolean required) {
		this.type = type;
		this.required = required;
	}

	public abstract Item convert();
}
