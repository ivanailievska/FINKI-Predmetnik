package com.finki.ukim.mk.predmetnik.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;

    private String surname;

    private String link;

    @ManyToMany
    private List<Course> teachingCourses;

    public Professor(String firstName, String lastName, String link, List<Course> courses) {
        this.name = firstName;
        this.surname = lastName;
        this.link = link;
        this.teachingCourses = courses;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }
}