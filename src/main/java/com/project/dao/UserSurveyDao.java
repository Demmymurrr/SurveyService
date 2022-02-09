package com.project.dao;

import com.project.model.Answer;
import com.project.model.Survey;
import com.project.model.User;
import com.project.model.UserSurvey;
import java.util.List;

public interface UserSurveyDao {

    List<UserSurvey> getAllPassed(Long id);

    List<Answer> getResultById(Long user_survey_id);


}
