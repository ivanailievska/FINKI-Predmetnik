package com.finki.ukim.mk.predmetnik.repository;

import com.finki.ukim.mk.predmetnik.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAll();

    @Override
    Optional<Course> findById(Integer id);

    Optional<Course> findByName(String name);
}