package com.finki.ukim.mk.predmetnik.web;

import com.finki.ukim.mk.predmetnik.models.Comment;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.service.CommentService;
import com.finki.ukim.mk.predmetnik.service.CourseService;
import com.finki.ukim.mk.predmetnik.service.StudentService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final CourseService courseService;
    private final StudentService studentService;

    public CommentController(CommentService commentService, CourseService courseService, StudentService studentService) {
        this.commentService = commentService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @PostMapping("/add/{course}")
    public String saveComment(HttpServletRequest request,
                              @PathVariable Integer course) {
        Comment comment = new Comment(LocalDateTime.now(), request.getParameter("commentBody"));
        Student student = this.studentService.findById(Integer.parseInt(request.getRemoteUser())).get();
        comment.setAuthorName(student.getFullName());
        this.courseService.findById(course).get().getComments().add(comment);
        this.commentService.addComment(comment);
        return "redirect:/courses/details/{course}";
    }

    @GetMapping("/like/{id}/{course}")
    public String likeComment(@PathVariable Integer id,
                              @PathVariable Integer course) {
        Comment comment = this.commentService.findById(id);
        this.commentService.likeComment(comment);
        return "redirect:/courses/details/{course}";
    }

    @GetMapping("/dislike/{id}/{course}")
    public String dislikeComment(@PathVariable Integer id,
                                 @PathVariable Integer course) {
        Comment comment = this.commentService.findById(id);
        this.commentService.disLikeComment(comment);
        return "redirect:/courses/details/{course}";
    }
}