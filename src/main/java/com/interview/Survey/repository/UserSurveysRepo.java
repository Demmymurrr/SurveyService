package com.interview.Survey.repository;


import com.interview.Survey.entity.UserSurveys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSurveysRepo  extends JpaRepository<UserSurveys,Long> {
}
