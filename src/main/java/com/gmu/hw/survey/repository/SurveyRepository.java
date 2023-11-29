package com.gmu.hw.survey.repository;

import com.gmu.hw.survey.model.SurveyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyModel,Long> {

}
