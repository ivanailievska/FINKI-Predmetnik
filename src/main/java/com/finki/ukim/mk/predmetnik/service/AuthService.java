package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.exceptions.InvalidArgumentsException;
import com.finki.ukim.mk.predmetnik.exceptions.InvalidUserCredentialsException;
import com.finki.ukim.mk.predmetnik.models.Student;

public interface AuthService {
    Student login(String username, String password) throws InvalidUserCredentialsException, InvalidArgumentsException;
}
