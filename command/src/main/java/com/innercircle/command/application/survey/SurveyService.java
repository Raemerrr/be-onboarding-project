package com.innercircle.command.application.survey;

import com.innercircle.command.domain.survey.Survey;
import com.innercircle.command.domain.survey.SurveyRepository;
import com.innercircle.command.domain.survey.item.Item;
import java.util.List;
import java.util.UUID;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SurveyService {

	private final SurveyRepository surveyRepository;

	public SurveyService(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;
	}

	public UUID create(String name, String description, List<ItemInput> itemInputs) {
		if (StringUtils.isAnyBlank(name, description)) {
			throw new IllegalArgumentException("Survey name or description must not be empty");
		}
		if (CollectionUtils.isEmpty(itemInputs)) {
			throw new IllegalArgumentException("Survey must have at least one item");
		}

		var items = itemInputs.stream()
				.map(ItemInput::convert)
				.toList();

		items.forEach(Item::validate);

		var survey = new Survey(UUID.randomUUID(), name, description, items);
		surveyRepository.save(survey);
		return survey.getId();
	}
}
