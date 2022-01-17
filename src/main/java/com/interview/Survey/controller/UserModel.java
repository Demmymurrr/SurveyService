package com.interview.Survey.controller;

import com.interview.Survey.entity.Answer;
import com.interview.Survey.entity.Survey;
import com.interview.Survey.entity.User;
import com.interview.Survey.repository.AnswerRepo;
import com.interview.Survey.repository.SurveyRepo;
import com.interview.Survey.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class UserModel {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SurveyRepo surveyRepo;
    @Autowired
    private AnswerRepo answerRepo;

    public List<Survey> getActiveSurveyList() {
        return surveyRepo.findAll().stream().filter(survey -> (survey.getDate_start().before(new Date()) &&
                survey.getDate_stop().after(new Date()))).toList();
    }

    public Survey getOneActiveSurvey(String id) {
        long idSurvey = Long.parseLong(id);
        return getActiveSurveyList().stream().filter(survey -> survey.getId() == idSurvey).findAny().orElseThrow(null);
    }

    public Answer postSurveyAnswer(String login, String idSurv, Map<String,String> map) {
        long idSurvey = Long.parseLong(idSurv);
        User user = userRepo.findAll().stream().filter(user1 -> user1.getLogin().equals(login)).findAny().orElseThrow(null);
        Answer answer = answerRepo.findAll().stream().filter(answer1 -> answer1.getId_survey()==idSurvey)
                .filter(answer1 -> answer1.getId_user() == user.getId()).findAny().orElse(new Answer(user.getId(), idSurvey));
        answer.setAnswers(map);
        answer.setAnswerFromMap(answer.getMapAnswers());
        answerRepo.save(answer);
        return answer;
    }

    public List<Answer> getPassedSurveys(String login) {
        User user = userRepo.findAll().stream().filter(user1 -> user1.getLogin().equals(login)).findAny().orElseThrow(null);
        return answerRepo.findAll().stream().filter(answer -> answer.getId_user()== user.getId()).toList();
    }
}
