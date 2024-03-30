package com.finki.ukim.mk.predmetnik.models;

import jakarta.persistence.*;
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