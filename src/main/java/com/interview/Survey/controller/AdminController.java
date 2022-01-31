package com.interview.Survey.controller;


import com.interview.Survey.entity.Survey;
import com.interview.Survey.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {


    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Survey> create(@RequestBody Survey survey) {
        Survey createdSurvey = adminService.create(survey);

        return new ResponseEntity<Survey>(createdSurvey, HttpStatus.OK);
    }


    @PostMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Survey> update(@PathVariable("id") Long id,
                                         @RequestBody Survey survey) {
        Survey updatedSurvey = adminService.update(id, survey);

        return new ResponseEntity<Survey>(updatedSurvey, HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Survey> delete (@PathVariable("id") Long id) {
        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
