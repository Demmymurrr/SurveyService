package com.interview.Authorization_and_survey.repository;

import com.interview.Authorization_and_survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepo extends JpaRepository<Survey,Long> {
}
