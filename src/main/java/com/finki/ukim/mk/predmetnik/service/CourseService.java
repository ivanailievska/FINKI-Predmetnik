package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    Optional<Course> findById(Integer id);

    void save(Course course);

    Optional<Course> findByName(String name);

}
