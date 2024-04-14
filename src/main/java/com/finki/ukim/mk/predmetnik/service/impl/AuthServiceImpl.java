package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.exceptions.InvalidUserCredentialsException;
import com.finki.ukim.mk.predmetnik.exceptions.exceptions.InvalidArgumentsException;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.repository.StudentRepository;
import com.finki.ukim.mk.predmetnik.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final StudentRepository studentRepository;


    public AuthServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student login(String username, String password) throws InvalidUserCredentialsException, InvalidArgumentsException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return studentRepository.findByIndexAndPassword(Integer.parseInt(username),
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
