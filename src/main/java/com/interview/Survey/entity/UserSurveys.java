package com.interview.Survey.entity;

import javax.persistence.*;

/**
 * Simple JavaBean object that show surveys User passed.
 *
 * @author Maxim Semenov
 * @version 1.0
 */

@Entity
@Table(name = "user_surveys")
public class UserSurveys {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    public UserSurveys() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
