package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Course;
import com.finki.ukim.mk.predmetnik.models.Personal;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.repository.PersonalRepository;
import com.finki.ukim.mk.predmetnik.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PersonalServiceImplTest {

    @Mock
    private PersonalRepository personalRepository;

    @Mock
    private StudentRepository studentRepository;


    @InjectMocks
    private PersonalServiceImpl personalService;

    @Test
    public void testListAllCoursesInPersonal() {
        // Given
        Student student = new Student();
        Personal personal = new Personal(student, new ArrayList<>());
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Math", 1));
        courses.add(new Course("Physics", 2));
        personal.setPersonalCourses(courses);

        when(personalRepository.findById(1)).thenReturn(Optional.of(personal));

        // When
        List<Course> result = personalService.listAllCoursesInPersonal(1);

        // Then
        assertEquals(courses, result);
    }

    @Test
    public void testGetActivePersonal_existingPersonal() {
        // Given
        Student student = new Student();
        Personal personal = new Personal(student, new ArrayList<>());

        when(studentRepository.findById(1)).thenReturn(Optional.of(student));
        when(personalRepository.findByOwner(student)).thenReturn(Optional.of(personal));

        // When
        Personal result = personalService.getActivePersonal(1);

        // Then
        assertEquals(personal, result);
    }

//    @Test
//    public void testAddCourseToPersonal() {
//        // Given
//        Student student = new Student();
//        Personal personal = new Personal(student, new ArrayList<>());
//        Course course = new Course("Math", 1);
//
//        when(personalRepository.findById(1)).thenReturn(Optional.of(personal));
//        when(courseRepository.getById(1)).thenReturn(course);
//
//        // When
//        Personal result = personalService.addCourseToPersonal(1, 1);
//
//        // Then
//        assertEquals(1, result.getPersonalCourses().size());
//        assertEquals(course, result.getPersonalCourses().get(0));
//    }

    @Test
    public void testSave() {
        // Given
        Personal personal = new Personal();

        // When
        personalService.save(personal);

        // Then
        verify(personalRepository, times(1)).save(personal);
    }
}
