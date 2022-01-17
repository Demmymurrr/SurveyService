package com.interview.Survey.controller;

import com.interview.Survey.entity.Answer;
import com.interview.Survey.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {


    @Autowired
    private UserModel userModel;

    @GetMapping
    public List<Survey> getActiveSurveyList() {
        return userModel.getActiveSurveyList();
    }

    @GetMapping("{id}")
    public Survey getOneActiveSurvey(@PathVariable("id") String id) {
        return userModel.getOneActiveSurvey(id);
    }

    @PostMapping("{id}")
    public Answer postSurveyAnswer(@PathVariable("id") String idSurvey,
                                   @RequestBody Map<String,String> map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        return userModel.postSurveyAnswer(login,idSurvey,map);
    }

    @GetMapping("/passed")
    public List<Answer> getPassedSurvey() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        return userModel.getPassedSurveys(login);
    }

}
