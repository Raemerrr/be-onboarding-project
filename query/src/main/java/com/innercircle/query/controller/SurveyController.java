package com.innercircle.query.controller;

import com.innercircle.query.controller.dto.AnswerDto;
import com.innercircle.query.controller.dto.SurveyDto;
import com.innercircle.query.controller.dto.SurveyResponsesDto;
import com.innercircle.query.facade.SurveyFacade;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@QueryInterface
public class SurveyController {

	private final SurveyFacade surveyFacade;

	public SurveyController(SurveyFacade surveyFacade) {
		this.surveyFacade = surveyFacade;
	}

	@GetMapping("/surveys/{surveyId}")
	public SurveyDto getSurvey(@PathVariable String surveyId) {
		return surveyFacade.getSurvey(surveyId);
	}

	@GetMapping("/surveys/{surveyId}/responses")
	public SurveyResponsesDto getSurveyResponses(@PathVariable String surveyId) {
		return surveyFacade.getSurveyResponses(surveyId);
	}

	@GetMapping("/answers/search")
	public List<AnswerDto> searchAnswers(@RequestParam String query) {
		return surveyFacade.searchAnswers(query);
	}
}
