package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Comment;
import com.finki.ukim.mk.predmetnik.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Test
    public void shouldAddComment(){
        Comment comment = new Comment();
        comment.setBody("Test comment");
        comment.setLikes(0);
        comment.setDislikes(0);
        comment.setAuthorName("John Doe");
        comment.setTimestamp(LocalDateTime.now());

        // When
        commentService.addComment(comment);

        // Then
        verify(commentRepository, times(1)).save(comment);
    }

    @Test
    public void shouldFindCommentById() {
        // Given
        Comment comment = new Comment();
        comment.setID(1);
        comment.setBody("Test comment");
        comment.setLikes(0);
        comment.setDislikes(0);
        comment.setAuthorName("John Doe");
        comment.setTimestamp(LocalDateTime.now());

        when(commentRepository.findById(1)).thenReturn(Optional.of(comment));

        // When
        Comment result = commentService.findById(1);

        // Then
        assertEquals(comment, result);

        verify(commentRepository, times(1)).findById(1);
    }

    @Test
    public void shouldLikeComment() {
        // Given
        Comment comment = new Comment();
        comment.setLikes(0);

        // When
        commentService.likeComment(comment);

        // Then
        assertEquals(1, comment.getLikes());

        verify(commentRepository, times(1)).save(comment);
    }

    @Test
    public void shouldDislikeComment() {
        // Given
        Comment comment = new Comment();
        comment.setDislikes(0);

        // When
        commentService.disLikeComment(comment);

        // Then
        assertEquals(1, comment.getDislikes());

        verify(commentRepository, times(1)).save(comment);
    }
}
