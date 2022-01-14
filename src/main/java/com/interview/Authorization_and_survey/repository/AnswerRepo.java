package com.interview.Authorization_and_survey.repository;

import com.interview.Authorization_and_survey.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer,Long> {
}
