package com.project.dao;

import com.project.model.Survey;
import java.io.Serializable;
import java.util.List;

public interface SurveyDao {

    Serializable saveSurvey(Survey survey);
    Serializable updateSurvey(Survey survey, Long id);
    void deleteSurvey(Long id);
    List<Survey> getAll();
    List<Survey> getAllActive();
    Survey getOneActiveById(Long id);
    Survey getById(Long id);
}
