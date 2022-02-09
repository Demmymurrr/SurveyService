package com.project.dao;

import com.project.model.Answer;
import com.project.model.Question;
import com.project.model.Survey;
import com.project.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class SurveyDaoImpl implements SurveyDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        getSession().beginTransaction();
        getSession().save(survey);
        for (Question question: survey.getQuestionList()) {
            getSession().save(question);
            for (Answer answer: question.getAnswerList()) {
                getSession().save(answer);
            }
        }
        getSession().getTransaction().commit();
        return survey;
    }

    @Override
    public Survey updateSurvey(Survey new_survey, Long id) {
        new_survey.setId(id);
        getSession().beginTransaction();
        Survey old_survey = getSession().get(Survey.class, id);
        // delete unusable data from old survey
        for (Question old_question : old_survey.getQuestionList()) {
            //delete unusable Questions
            Long old_quest_id = old_question.getId();
            Question questionFromNewSubveyWithOldId = new_survey.getQuestionList().stream()
                    .filter(question -> question.getId().equals(old_quest_id))
                    .findFirst().orElse(null);
            if (questionFromNewSubveyWithOldId == null) {
                for (Answer answer : old_question.getAnswerList()) {
                    getSession().delete(answer);
                }
                getSession().delete(old_question);
                continue;
            }
            //delete unusable Answers
            for (Answer old_answer : old_question.getAnswerList()) {
                Long old_ans_id = old_answer.getAnswer_id();
                Answer answerFromNewSubveyWithOldId = questionFromNewSubveyWithOldId
                        .getAnswerList().stream().filter(answer -> answer.getAnswer_id().equals(old_ans_id))
                        .findFirst().orElse(null);
                if (answerFromNewSubveyWithOldId == null) {
                    getSession().delete(old_answer);
                }
            }
        }
        getSession().flush();
        getSession().clear();

        // update survey
        getSession().update(new_survey);
        for (Question question : new_survey.getQuestionList()) {
            getSession().saveOrUpdate(question);
            for (Answer answer : question.getAnswerList()) {
                getSession().saveOrUpdate(answer);
            }
        }

        getSession().getTransaction().commit();
        return new_survey;
    }

    @Override
    public void deleteSurvey(Long id) {
        getSession().beginTransaction();
        Survey survey = getSession().get(Survey.class, id);
        for (Question question : survey.getQuestionList()) {
            for (Answer answer : question.getAnswerList()) {
                getSession().delete(answer);
            }
            getSession().delete(question);
        }
        getSession().delete(survey);
        getSession().getTransaction().commit();
    }

    @Override
    public List<Survey> getAll() {
        List<Survey> surveys = getSession().createQuery("from " + Survey.class.getSimpleName()).list();
        return surveys;
    }

    @Override
    public List<Survey> getAllActive() {
        Date date = new Date();
        List<Survey> surveys = getSession().createQuery("from Survey s where s.start < :start and s.stop > :stop")
                .setParameter("start",date).setParameter("stop",date).list();
        return surveys;
    }

    @Override
    public Survey getOneActiveById(Long id) {
        return getAllActive().stream().filter(survey -> survey.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Survey getById(Long id) {
        return getSession().get(Survey.class,id);
    }
}
