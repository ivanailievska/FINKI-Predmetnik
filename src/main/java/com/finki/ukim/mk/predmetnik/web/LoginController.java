package com.finki.ukim.mk.predmetnik.web;

import com.finki.ukim.mk.predmetnik.exceptions.exceptions.InvalidArgumentsException;
import com.finki.ukim.mk.predmetnik.exceptions.InvalidUserCredentialsException;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.service.AuthService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;


    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request,
                        Model model) {
        Student student = null;
        try {
            student = this.authService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", student);
            return "redirect:/courses";
        } catch (InvalidUserCredentialsException | InvalidArgumentsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }

    }
}
