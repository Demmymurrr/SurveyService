package com.interview.Survey.controller;


import com.interview.Survey.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private AdminModel adminModel;

    @PostMapping()
    public Survey create(@RequestBody Map<String,String> map) {
        return adminModel.addSurvey(map);
    }

    @PostMapping("{id}")
    public Survey update(@PathVariable("id") String id,
                         @RequestBody Map<String,String> map) {
        return adminModel.update(id, map);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable("id") String id) {
        adminModel.delete(id);
    }




}
