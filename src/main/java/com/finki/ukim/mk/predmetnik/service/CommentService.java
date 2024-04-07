package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.models.Comment;
import com.finki.ukim.mk.predmetnik.models.Course;
import com.finki.ukim.mk.predmetnik.models.Personal;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);

    Comment findById(Integer id);

    void likeComment(Comment comment);

    void disLikeComment(Comment comment);

    interface PersonalService {
        List<Course> listAllCoursesInPersonal(Integer id);
        Personal getActivePersonal(Integer index);
        Personal addCourseToPersonal(Integer index, Integer courseId);

        void save(Personal personalToDeleteFrom);
    }
}
