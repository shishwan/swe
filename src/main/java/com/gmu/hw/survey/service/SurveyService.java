package com.gmu.hw.survey.service;

import com.gmu.hw.survey.model.SurveyModel;
import com.gmu.hw.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<SurveyModel> getAllSurveys(){
        return surveyRepository.findAll();
    }

    public SurveyModel saveSurvey(SurveyModel survey){
        return surveyRepository.save(survey);
    }

    public Optional<SurveyModel> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    public void delete(SurveyModel student) { surveyRepository.delete(student); }

}
