package com.interview.Survey.service;

import com.interview.Survey.entity.Survey;
import com.interview.Survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService{

    @Autowired
    private SurveyRepo surveyRepo;

    public Survey create(Survey survey) {
        surveyRepo.save(survey);
        return survey;
    }

    public Survey update(Long id, Survey survey) {
        Survey sur =surveyRepo.findAll().stream().filter(survey1 -> survey1.getId() == id).findAny().orElse(null);
        if (sur == null) return null;
        survey.setId(id);
        surveyRepo.save(survey);
        return survey;

    }

    public void delete(Long id) {
        surveyRepo.deleteById(id);
    }
}
