package com.interview.Survey.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "user_answers")
public class Answer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "user_surveys_id")
    private UserSurveys userSurveys;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UserSurveys getUserSurveys() {
        return userSurveys;
    }

    public void setUserSurveys(UserSurveys userSurveys) {
        this.userSurveys = userSurveys;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
