package com.finki.ukim.mk.predmetnik.web;

import com.finki.ukim.mk.predmetnik.models.Comment;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.service.CommentService;
import com.finki.ukim.mk.predmetnik.service.CourseService;
import com.finki.ukim.mk.predmetnik.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/add/{course}")
    public String saveComment(HttpServletRequest request,
                              @PathVariable Integer course) {
        Comment comment = new Comment();
        comment.setTimestamp(LocalDateTime.now());
        comment.setBody(request.getParameter("commentBody"));

        Student student = this.studentService.findById(Integer.parseInt(request.getRemoteUser())).orElse(null);
        comment.setAuthorName(Objects.requireNonNull(student).getFullName());

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