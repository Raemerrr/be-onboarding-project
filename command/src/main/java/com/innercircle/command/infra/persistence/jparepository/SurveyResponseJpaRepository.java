package com.innercircle.command.infra.persistence.jparepository;

import com.innercircle.command.domain.survey.SurveyResponse;
import org.springframework.data.repository.CrudRepository;

public interface SurveyResponseJpaRepository extends CrudRepository<SurveyResponse, String> {

}
