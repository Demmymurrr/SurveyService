package com.interview.Authorization_and_survey.entity;

import org.json.JSONArray;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date date_start;
    private Date date_stop;
    private String description;
    private String questsFromJson;
    @Transient
    private List<Question> questionList;


    public Survey(String name, Date date_start, Date date_stop, String description, List<Question> questionList) {
        this.name = name;
        this.date_start = date_start;
        this.date_stop = date_stop;
        this.description = description;
        this.questionList = questionList;
    }

    public Survey(String name, Date date_start, Date date_stop, String description, String questsFromJson) {
        this.name = name;
        this.date_start = date_start;
        this.date_stop = date_stop;
        this.description = description;
        this.questsFromJson = questsFromJson;
    }

    public Survey() {

    }

    public Survey getOriginal() {
        Survey survey = new Survey(name, date_start, date_stop, description, getJSONQuestionList());
        return survey;
    }

    public String getJSONQuestionList() {
        JSONArray obj = new JSONArray(questionList);
        return obj.toString();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_stop() {
        return date_stop;
    }

    public void setDate_stop(Date date_stop) {
        this.date_stop = date_stop;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestsFromJson() {
        return questsFromJson;
    }

    public void setQuestsFromJson(String questsFromJson) {
        this.questsFromJson = questsFromJson;
    }
}
