package com.gmu.hw.survey.controller;

import com.gmu.hw.survey.exception.SurveyException;
import com.gmu.hw.survey.model.SurveyModel;
import com.gmu.hw.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/home")
    public String home(){
        return  "Campus Survey APP";
    }


    @GetMapping("/all")
    public List<SurveyModel> getAllSurveys(){
        return surveyService.getAllSurveys();
    }

    @PostMapping("/newStudent")
    public SurveyModel createSurvey(@RequestBody SurveyModel survey){
        return surveyService.saveSurvey(survey);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<SurveyModel> getIdSurvey(@PathVariable Long id){
        SurveyModel student = surveyService.getSurveyById(id)
                .orElseThrow(()-> new SurveyException("Not found "+id));
        return ResponseEntity.ok(student);
    }


    @PutMapping("/oldStudent/{id}")
    public ResponseEntity<SurveyModel> updateSurvey(@PathVariable Long id, @RequestBody SurveyModel survey){
        SurveyModel student = surveyService.getSurveyById(id)
                .orElseThrow(()-> new SurveyException("Not found "+id));
        student.setFirstName(survey.getFirstName());
        student.setLastName(survey.getLastName());
        student.setStreetAddress(survey.getStreetAddress());
        student.setCity(survey.getCity());
        student.setState(survey.getState());
        student.setZip(survey.getZip());
        student.setTelephoneNumber(survey.getTelephoneNumber());
        student.setEmail(survey.getEmail());
        student.setDateOfSurvey(survey.getDateOfSurvey());
        student.setLikedAboutCampus(survey.getLikedAboutCampus());
        student.setInterestSource(survey.getInterestSource());
        student.setLikedAboutCampus(survey.getLikedAboutCampus());
        student.setAdditionalComments(survey.getAdditionalComments());

        SurveyModel updateStudent = surveyService.saveSurvey(student);
        return  ResponseEntity.ok(updateStudent);
    }



    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteSurvey(@PathVariable Long id){
        SurveyModel student = surveyService.getSurveyById(id)
                .orElseThrow(()-> new SurveyException("Not found "+id));
        surveyService.delete(student);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }

}
