package com.interview.Survey.controller;

import com.interview.Survey.entity.Answer;
import com.interview.Survey.entity.Survey;
import com.interview.Survey.entity.UserSurveys;
import com.interview.Survey.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Survey>> getActiveSurveyList() {
        List<Survey> surveys = service.getActiveSurveyList();

        return new ResponseEntity<List<Survey>>(surveys,HttpStatus.OK);
    }

    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Survey> getOneActiveSurvey(@PathVariable("id") Long id) {
        Survey survey = service.getOneActiveSurvey(id);

        return new ResponseEntity<Survey>(survey,HttpStatus.OK);
    }

    @PostMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserSurveys> createAnswers(@PathVariable("id") Long idSurvey,
                                                     @RequestBody Map<Long,String> ansers) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserSurveys userSurveys = service.createAnswers(idSurvey,ansers,username);
        return new ResponseEntity<UserSurveys>(userSurveys, HttpStatus.OK);
    }

    @GetMapping(value = "/passed",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UserSurveys>> getPassedSurvey() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<UserSurveys> answers = service.getPassedSurvey(username);

        return new ResponseEntity<List<UserSurveys>>(answers, HttpStatus.OK);
    }

}
