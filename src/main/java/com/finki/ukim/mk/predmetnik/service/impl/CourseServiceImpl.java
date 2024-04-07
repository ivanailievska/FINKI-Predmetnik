package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Course;
import com.finki.ukim.mk.predmetnik.repository.CourseRepository;
import com.finki.ukim.mk.predmetnik.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl  implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public void save(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public Optional<Course> findByName(String name) {
        return this.courseRepository.findByName(name);
    }
}
