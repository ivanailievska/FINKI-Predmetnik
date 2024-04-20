package com.finki.ukim.mk.predmetnik.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;

    @ManyToMany
    private List<Course> coursesInProgram;

    public Program() {}

    public Program(Integer ID, String name, List<Course> coursesInProgram) {
        this.ID = ID;
        this.name = name;
        this.coursesInProgram = coursesInProgram;
    }
}