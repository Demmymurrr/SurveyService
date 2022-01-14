package com.interview.Authorization_and_survey.controller;


import com.interview.Authorization_and_survey.entity.AnswerType;
import com.interview.Authorization_and_survey.entity.Question;
import com.interview.Authorization_and_survey.entity.Survey;
import com.interview.Authorization_and_survey.repository.SurveyRepo;
import org.json.JSONArray;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class AdminModel {

    private final SurveyRepo surveyRepo;

    public AdminModel(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }


    public Survey addSurvey(Map<String,String> mapa) {
        Survey support = getSurveySupport(mapa);
        Survey survey = support.getOriginal();
        surveyRepo.save(survey);
        return survey;
    }

    public Survey update(String id, Map<String,String> mapa) {
        Survey support = getSurveySupport(mapa);
        long idSurvey = Long.parseLong(id);
        Survey survey = surveyRepo.findAll().stream().filter(survey1 -> survey1.getId()==idSurvey).findAny().orElseThrow(null);

        if (support.getName() != null) {
            survey.setName(support.getName());
        }
        if (support.getDate_stop() != null) {
            survey.setDate_stop(support.getDate_stop());
        }

        if (support.getDescription() != null) {
            survey.setDescription(support.getDescription());
        }

        if (support.getQuestionList() != null) {
            survey.setQuestsFromJson(support.getJSONQuestionList());
        }

        surveyRepo.save(survey);
        return survey;
    }

    public void delete(String id) {
        long idSurvey = Long.parseLong(id);
        Survey survey = surveyRepo.findAll().stream().filter(survey1 -> survey1.getId()==idSurvey).findAny().orElseThrow(null);
        surveyRepo.delete(survey);
    }


    private Survey getSurveySupport(Map<String,String> mapa) {
        String name = mapa.get("name");
        Date start = new Date(Long.parseLong(mapa.get("date_start")));
        Date stop = new Date(Long.parseLong(mapa.get("date_stop")));
        String description = mapa.get("description");
        JSONArray array = new JSONArray(mapa.get("questsFromJson"));
        List<Question> questList = new ArrayList<>();
        for (int i=0; i< array.length();i++) {
            Question question = new Question();
            question.setQuestBody(array.getJSONObject(i).getString("questBody"));
            question.setAnswerType(AnswerType.valueOf(array.getJSONObject(i).getString("answerType")));
            List<String> answerList = new ArrayList<>();
            JSONArray answArray = array.getJSONObject(i).getJSONArray("varsAnswer");
            for (int j=0;j< answArray.length();j++) {
                answerList.add(answArray.getString(j));
            }
            question.setVarsAnswer(answerList);
            questList.add(question);
        }
        return new Survey(name,start,stop,description,questList);
    }


}
