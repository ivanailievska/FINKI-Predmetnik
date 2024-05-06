package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Course;
import com.finki.ukim.mk.predmetnik.models.Personal;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.repository.CourseRepository;
import com.finki.ukim.mk.predmetnik.repository.PersonalRepository;
import com.finki.ukim.mk.predmetnik.repository.StudentRepository;
import com.finki.ukim.mk.predmetnik.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> listAllCoursesInPersonal(Integer id) {
        return this.personalRepository.findById(id).get().getPersonalCourses();
    }

    @Override
    public Personal getActivePersonal(Integer index) {
        Student student = this.studentRepository.findById(index).get();
        if (this.personalRepository.findByOwner(student).isPresent())
            return this.personalRepository.findByOwner(student).get();
        else {
            return this.personalRepository.save(new Personal(student, new ArrayList<>()));
        }
    }


    @Override
    public Personal addCourseToPersonal(Integer index, Integer courseId) {
        Personal personal = this.getActivePersonal(index);
        Course course = this.courseRepository.getById(courseId);
        personal.getPersonalCourses().add(course);
        return this.personalRepository.save(personal);
    }

    @Override
    public void save(Personal personalToDeleteFrom) {
        this.personalRepository.save(personalToDeleteFrom);
    }

}