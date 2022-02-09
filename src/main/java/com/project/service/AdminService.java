package com.project.service;

import com.project.model.Survey;

import java.util.List;

public interface AdminService {

    Survey create(Survey survey);

    Survey update(Survey survey,Long id);

    void delete (Long id);

    List<Survey> getAll();
}
