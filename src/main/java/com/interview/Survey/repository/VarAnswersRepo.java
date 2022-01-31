package com.interview.Survey.repository;

import com.interview.Survey.entity.VarAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarAnswersRepo extends JpaRepository<VarAnswers,Long> {
}