package com.interview.Survey.service;

import com.interview.Survey.entity.*;
import com.interview.Survey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SurveyRepo surveyRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserSurveysRepo userSurveysRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @Override
    public User getByUsername(String username) {
        return userRepo.findAll().stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    @Override
    public User getById(Long id) {
        return userRepo.findAll().stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
    }

    public List<Survey> getActiveSurveyList() {
        Date date = new Date();
        List<Survey> surveys = surveyRepo.findAll().stream()
                .filter(survey -> (survey.getStart().before(date) && survey.getStop().after(date))).collect(Collectors.toList());
        return surveys;
    }
    public Survey getOneActiveSurvey(Long id) {
        List<Survey> active = getActiveSurveyList();
        return active.stream().filter(survey -> survey.getId()==id).findAny().orElse(null);
    }

    @Transactional
    public UserSurveys createAnswers(Long surveyId, Map<Long,String> answers, String username) {
        User user = getByUsername(username);
        UserSurveys userSurveys = new UserSurveys();
        userSurveys.setUser(user);
        Survey survey = surveyRepo.findAll().stream().filter(survey1 -> survey1.getId()==surveyId).findAny().orElse(null);
        userSurveys.setSurvey(survey);
        userSurveysRepo.save(userSurveys);

        for (Map.Entry<Long,String> entry: answers.entrySet()){
            Answer answer = new Answer();
            answer.setAnswer(entry.getValue());
            answer.setUserSurveys(userSurveys);
            Question question = questionRepo.findAll().stream().filter(question1 -> question1.getId().equals(entry.getKey())).findAny().orElseThrow(null);
            answer.setQuestion(question);
            answerRepo.save(answer);
        }

        return userSurveys;
    }

    public List<UserSurveys> getPassedSurvey(String username) {
        User user = getByUsername(username);
        List<UserSurveys> list = userSurveysRepo.findAll().stream().filter(userSurveys -> userSurveys.getUser().equals(user)).collect(Collectors.toList());
        return list;
    }


}
