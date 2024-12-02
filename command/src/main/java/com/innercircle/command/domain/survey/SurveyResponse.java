package com.innercircle.command.domain.survey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyResponse {

	@Id
	private String id;
	private String surveyId;

	SurveyResponse(String id, String surveyId) {
		this.id = id;
		this.surveyId = surveyId;
	}
}