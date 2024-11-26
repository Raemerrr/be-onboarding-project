package com.innercircle.command.domain.survey.item;

import java.io.Serializable;

public record ItemOption(String name, boolean selected) implements Serializable {

}
