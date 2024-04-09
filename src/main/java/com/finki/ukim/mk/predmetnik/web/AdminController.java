package com.finki.ukim.mk.predmetnik.web;

import com.finki.ukim.mk.predmetnik.exceptions.CourseAlreadyExistsException;
import com.finki.ukim.mk.predmetnik.exceptions.PreferenceAlreadyExistsException;
import com.finki.ukim.mk.predmetnik.exe.ProfessorAlreadyExistsException;
import com.finki.ukim.mk.predmetnik.models.Course;
import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.models.Professor;
import com.finki.ukim.mk.predmetnik.service.CourseService;
import com.finki.ukim.mk.predmetnik.service.PreferenceService;
import com.finki.ukim.mk.predmetnik.service.ProfessorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CourseService courseService;
    private final PreferenceService preferenceService;
    private final ProfessorService professorService;

    public AdminController(CourseService courseService, PreferenceService preferenceService, ProfessorService professorService) {
        this.courseService = courseService;
        this.preferenceService = preferenceService;
        this.professorService = professorService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminPage(Model model) {
        model.addAttribute("bodyContent", "admin");
        return "master-template";
    }

    @GetMapping("/add-course")
    public String getCourseForm(Model model) {
        model.addAttribute("bodyContent", "course-form");
        return "master-template";
    }

    @GetMapping("/add-preference")
    public String getPreferenceForm(Model model) {
        model.addAttribute("bodyContent", "preference-form");
        model.addAttribute("courses", this.courseService.findAll());
        return "master-template";
    }

    @GetMapping("/add-professor")
    public String getProfessorForm(Model model) {
        model.addAttribute("bodyContent", "professor-form");
        model.addAttribute("courses", this.courseService.findAll());
        return "master-template";
    }

    @PostMapping("/add-course")
    public String addCourse(@RequestParam String courseName,
                            @RequestParam Integer year) throws CourseAlreadyExistsException {
        Course course = new Course(courseName, year);
        if (this.courseService.findByName(course.getName()).isPresent())
            throw new CourseAlreadyExistsException();
        this.courseService.save(course);
        return "redirect:/admin";
    }

    @PostMapping("/add-preference")
    public String addPreference(@RequestParam String preferenceName,
                                @RequestParam List<Integer> courses) throws PreferenceAlreadyExistsException {
        if (this.preferenceService.findByName(preferenceName).isPresent())
            throw new PreferenceAlreadyExistsException();
        List<Course> coursesInPreference = courses.stream()
                .map(course -> this.courseService.findById(course).get())
                .collect(Collectors.toList());
        this.preferenceService.save(new Preference(preferenceName, coursesInPreference));
        return "redirect:/admin";
    }

    @PostMapping("/add-professor")
    public String addProfessor(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String link,
                               @RequestParam List<Integer> courses) throws ProfessorAlreadyExistsException {
        if (this.professorService.findByLink(link).isPresent())
            throw new ProfessorAlreadyExistsException();
        List<Course> teachingCourses = courses.stream()
                .map(course -> this.courseService.findById(course).get())
                .collect(Collectors.toList());
        this.professorService.save(new Professor(firstName, lastName, link, teachingCourses));
        return "redirect:/admin";
    }
}