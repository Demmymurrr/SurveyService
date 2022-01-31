package com.interview.Survey.repository;

import com.interview.Survey.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Long> {
}
