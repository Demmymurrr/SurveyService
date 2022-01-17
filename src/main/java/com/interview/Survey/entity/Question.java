package com.interview.Survey.entity;

import java.util.List;

public class Question {
    private String questBody;
    private AnswerType answerType;
    private List<String> varsAnswer;

    public Question(String questBody, AnswerType answerType, List<String> varsAnswer) {
        this.questBody = questBody;
        this.answerType = answerType;
        this.varsAnswer = varsAnswer;
    }

    public Question() {
    }

    public String getQuestBody() {
        return questBody;
    }

    public void setQuestBody(String questBody) {
        this.questBody = questBody;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public List<String> getVarsAnswer() {
        return varsAnswer;
    }

    public void setVarsAnswer(List<String> varsAnswer) {
        this.varsAnswer = varsAnswer;
    }
}
