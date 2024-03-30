package com.finki.ukim.mk.predmetnik.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;

    @ManyToMany
    private List<Course> suggestedCourses;

    public Preference() {
    }



    public Preference(String preferenceName, List<Course> coursesInPreference) {
        this.name = preferenceName;
        this.suggestedCourses = coursesInPreference;
    }

}
