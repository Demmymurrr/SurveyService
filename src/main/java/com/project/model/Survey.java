package com.project.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Entity
@Table(name = "SURVEY")
@Data
public class Survey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date start;

    @Column(name = "stop_date")
    private Date stop;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SURVEY_QUESTION",
               joinColumns = @JoinColumn(name = "survey_id"),
               inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Collection<Question> questionList= new ArrayList<>();
}
