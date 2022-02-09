package com.project.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Embeddable
@Table(name = "ANSWER")
@Data
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answer_id;

    @Column(name = "answer")
    private String answer;
}
