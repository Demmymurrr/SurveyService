package com.interview.Authorization_and_survey.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "answers_list")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long id_user;
    private long id_survey;
    private String answerFromMap;
    @Transient
    private Map<String, String> answers;


    public Answer(long id_user, long id_survey, String answerFromJson) {
        this.id_user = id_user;
        this.id_survey = id_survey;
        this.answerFromMap = answerFromJson;
    }

    public Answer(long id_user, long id_survey, Map<String,String> answers) {
        this.id_user = id_user;
        this.id_survey = id_survey;
        this.answers = answers;
    }

    public Answer(long id_user, long id_survey) {
        this.id_user = id_user;
        this.id_survey = id_survey;
    }

    public Answer() {

    }

    public Answer getOriginal() {
        Answer answer = new Answer(id_user,id_survey,getMapAnswers());
        return answer;
    }

    public String getMapAnswers() {
        return answers.toString();
    }

    public Map<String,String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String,String> answers) {
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_survey() {
        return id_survey;
    }

    public void setId_survey(long id_survey) {
        this.id_survey = id_survey;
    }

    public String getAnswerFromMap() {
        return answerFromMap;
    }

    public void setAnswerFromMap(String answerFromJson) {
        this.answerFromMap = answerFromJson;
    }
}
