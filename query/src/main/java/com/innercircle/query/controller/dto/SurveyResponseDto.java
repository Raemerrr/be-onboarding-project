package com.innercircle.query.controller.dto;

import com.innercircle.common.domain.survey.question.QuestionType;
import java.util.List;

public record SurveyResponseDto(String id, List<AnswerDto> answers) {

	public record AnswerDto(String id, String questionId, QuestionType questionType, boolean required, List<String> selectedOptions, String text) {

	}
}
