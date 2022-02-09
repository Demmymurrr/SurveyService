package com.project.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Simple JavaBean object that represents role of {@link User}
 *
 * @author Maxim Semenov
 * @version 1.0
 */

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roleList")
    private Collection<User> users = new ArrayList<>();
}