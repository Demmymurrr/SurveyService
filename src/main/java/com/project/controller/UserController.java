package com.project.controller;

import com.project.model.Answer;
import com.project.model.Survey;
import com.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/survey")
    public List<Survey> getAllActive() {
        return userService.getAllActive();
    }

    @GetMapping("/survey/passed")
    public List<Survey> getAllPassed () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.getAllPassed(username);
    }

    @GetMapping("/survey/passed/{id}")
    public List<Answer> getResultById(@PathVariable Long id) {
        return userService.getResultById(id);
    }

    @GetMapping("/survey/{id}")
    public Survey getOneActiveSurvey(@PathVariable Long id) {
        return userService.getOneActiveSurvey(id);
    }

}
