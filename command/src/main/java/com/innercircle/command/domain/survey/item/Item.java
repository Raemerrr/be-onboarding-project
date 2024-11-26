package com.innercircle.command.domain.survey.item;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
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
		@Type(value = ShortTextItem.class, name = "SHORT_TEXT"),
		@Type(value = LongTextItem.class, name = "LONG_TEXT"),
		@Type(value = SingleChoiceItem.class, name = "SINGLE_CHOICE"),
		@Type(value = MultipleChoiceItem.class, name = "MULTIPLE_CHOICE"),
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item implements Serializable {

	protected ItemType type;
	protected boolean required;

	protected Item(ItemType type, boolean required) {
		this.type = type;
		this.required = required;
	}

	public abstract void validate();
}
