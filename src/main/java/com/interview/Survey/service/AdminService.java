package com.interview.Survey.service;

import com.interview.Survey.entity.Survey;

public interface AdminService {
    Survey create(Survey survey);
    Survey update(Long id, Survey survey);
    void delete(Long id);
}
