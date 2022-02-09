package com.project.controller;

import com.project.model.Survey;
import com.project.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/survey/create")
    public Survey create(@RequestBody Survey survey) {
        return adminService.create(survey);
    }

    @PostMapping("/survey/update/{id}")
    public Survey update(@PathVariable Long id, @RequestBody Survey survey) {
        return adminService.update(survey,id);
    }

    @DeleteMapping("/survey/delete/{id}")
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }

    @GetMapping("/survey")
    public List<Survey> getAll() {
        return adminService.getAll();
    }
}
