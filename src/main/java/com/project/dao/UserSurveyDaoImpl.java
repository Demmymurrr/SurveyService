package com.project.dao;

import com.project.model.Answer;
import com.project.model.Survey;
import com.project.model.User;
import com.project.model.UserSurvey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserSurveyDaoImpl implements UserSurveyDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<UserSurvey> getAllPassed(Long id) {
        List<UserSurvey> userSurveys = getSession().createQuery("from UserSurvey us  where us.user.id= :id").setParameter("id",id).list();
        return userSurveys;
    }

    @Override
    public List<Answer> getResultById(Long user_survey_id) {
        List<Answer> answers = new ArrayList<>(getSession().get(UserSurvey.class, user_survey_id).getAnswers());
        return answers;
    }

}
