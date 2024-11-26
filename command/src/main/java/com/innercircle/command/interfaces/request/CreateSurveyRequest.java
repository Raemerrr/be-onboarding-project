package com.innercircle.command.interfaces.request;

import com.innercircle.command.application.survey.ItemInput;
import java.util.List;

public record CreateSurveyRequest(String name, String description, List<ItemInput> items) {

}
