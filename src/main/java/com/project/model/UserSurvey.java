package com.project.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_SURVEY")
@Data
public class UserSurvey implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Survey survey;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ANSWER", joinColumns = @JoinColumn(name = "user_survey_id"),
               inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Collection<Answer> answers = new ArrayList<>();

}
