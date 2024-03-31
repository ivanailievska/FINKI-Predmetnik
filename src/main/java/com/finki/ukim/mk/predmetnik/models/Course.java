package com.finki.ukim.mk.predmetnik.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;

    private Integer year;

    @OneToMany
    private List<Preference> comments;

    @ManyToMany(mappedBy = "teachingCourses")
    private List<Professor> professor;

    @Transient
    private boolean myCourse;

    public Course() {
    }

    public Course(Integer ID, String name, Integer year, List<Preference> comments) {
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.comments = comments;
        this.myCourse = false;
    }

    public Course(String courseName, Integer year) {
        this.name = courseName;
        this.year = year;
        this.comments = new ArrayList<>();
        this.professor = new ArrayList<>();
    }

    public boolean isMyCourse() {
        return myCourse;
    }

    public void setMyCourse(boolean myCourse) {
        this.myCourse = myCourse;
    }
}