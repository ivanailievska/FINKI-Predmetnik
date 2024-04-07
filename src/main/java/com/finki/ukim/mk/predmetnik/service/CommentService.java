package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.models.Comment;

public interface CommentService {
    void addComment(Comment comment);

    Comment findById(Integer id);

    void likeComment(Comment comment);

    void disLikeComment(Comment comment);
}
