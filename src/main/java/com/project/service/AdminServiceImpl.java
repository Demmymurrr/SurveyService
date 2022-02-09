package com.project.service;

import com.project.dao.SurveyDaoImpl;
import com.project.model.Survey;
import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private SurveyDaoImpl surveyDao;

    @Override
    public Survey create(Survey survey) {
        return surveyDao.saveSurvey(survey);
    }

    @Override
    public Survey update(Survey survey, Long id) {
        return surveyDao.updateSurvey(survey,id);
    }

    @Override
    public void delete(Long id) {
        surveyDao.deleteSurvey(id);
    }

    @Override
    public List<Survey> getAll() {
        return surveyDao.getAll();
    }
}
