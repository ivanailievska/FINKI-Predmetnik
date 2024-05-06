package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Course;
import com.finki.ukim.mk.predmetnik.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Test
    public void shouldFindAllCourses() {
        // Given
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Math", 1));
        courses.add(new Course("Physics", 2));

        when(courseRepository.findAll()).thenReturn(courses);

        // When
        List<Course> result = courseService.findAll();

        // Then
        assertEquals(courses.size(), result.size());
        assertEquals(courses.get(0), result.get(0));
        assertEquals(courses.get(1), result.get(1));

        verify(courseRepository, times(1)).findAll();
    }

    @Test
    public void shouldFindCourseById() {
        // Given
        Course course = new Course("Math", 1);

        when(courseRepository.findById(1)).thenReturn(Optional.of(course));

        // When
        Optional<Course> result = courseService.findById(1);

        // Then
        assertTrue(result.isPresent());
        assertEquals(course, result.get());

        verify(courseRepository, times(1)).findById(1);
    }

    @Test
    public void shouldSaveCourse() {
        // Given
        Course course = new Course("Math", 1);

        // When
        courseService.save(course);

        // Then
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    public void shouldFindCourseByName() {
        // Given
        Course course = new Course("Math", 1);

        when(courseRepository.findByName("Math")).thenReturn(Optional.of(course));

        // When
        Optional<Course> result = courseService.findByName("Math");

        // Then
        assertTrue(result.isPresent());
        assertEquals(course, result.get());

        verify(courseRepository, times(1)).findByName("Math");
    }
}