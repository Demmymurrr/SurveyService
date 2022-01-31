package com.interview.Survey.service;

import com.interview.Survey.entity.Survey;
import com.interview.Survey.entity.User;
import com.interview.Survey.entity.UserSurveys;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getByUsername(String username);
    User getById(Long id);
    List<Survey> getActiveSurveyList();
    Survey getOneActiveSurvey(Long id);
    UserSurveys createAnswers(Long surveyId, Map<Long,String> answers, String username);
    List<UserSurveys> getPassedSurvey(String username);
}
