package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Comment;
import com.finki.ukim.mk.predmetnik.repository.CommentRepository;
import com.finki.ukim.mk.predmetnik.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl  implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {
        this.commentRepository.save(comment);
    }

    @Override
    public Comment findById(Integer id) {
        return this.commentRepository.findById(id).orElse(null);
    }

    @Override
    public void likeComment(Comment comment) {
        comment.setLikes(Math.addExact(comment.getLikes(), 1));
        this.commentRepository.save(comment);
    }

    @Override
    public void disLikeComment(Comment comment) {
        comment.setDislikes(Math.addExact(comment.getDislikes(), 1));
        this.commentRepository.save(comment);
    }
}
