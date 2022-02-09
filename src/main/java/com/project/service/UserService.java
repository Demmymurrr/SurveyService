package com.project.service;

import com.project.model.Answer;
import com.project.model.Survey;

import java.util.List;

public interface UserService {
    List<Survey> getAllActive();
    List<Survey> getAllPassed(String username);
    List<Answer> getResultById(Long id);
    Survey getOneActiveSurvey(Long id);
}
