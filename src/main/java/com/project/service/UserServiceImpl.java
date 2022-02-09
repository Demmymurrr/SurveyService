package com.project.service;

import com.project.dao.SurveyDaoImpl;
import com.project.dao.UserDaoImpl;
import com.project.dao.UserSurveyDaoImpl;
import com.project.model.Answer;
import com.project.model.Survey;
import com.project.model.User;
import com.project.model.UserSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SurveyDaoImpl surveyDao;

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private UserSurveyDaoImpl userSurveyDao;

    @Override
    public List<Survey> getAllActive() {
        return surveyDao.getAllActive();
    }

    @Override
    public List<Survey> getAllPassed(String username) {
        User user = userDao.getIdByUsername(username);
        return userSurveyDao.getAllPassed(user.getId()).stream().map(UserSurvey::getSurvey).collect(Collectors.toList());
    }

    @Override
    public List<Answer> getResultById(Long id) {
        return userSurveyDao.getResultById(id);
    }

    @Override
    public Survey getOneActiveSurvey(Long id) {
        return surveyDao.getOneActiveById(id);
    }

}
