package com.interview.Survey.entity;

import javax.persistence.*;

@Entity
@Table(name = "var_answers")
public class VarAnswers {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


}
