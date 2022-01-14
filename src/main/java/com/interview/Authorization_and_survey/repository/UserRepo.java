package com.interview.Authorization_and_survey.repository;

import com.interview.Authorization_and_survey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
