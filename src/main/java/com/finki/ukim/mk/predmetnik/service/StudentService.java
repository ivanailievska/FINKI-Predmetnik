package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.exceptions.InvalidArgumentsException;
import com.finki.ukim.mk.predmetnik.exceptions.PasswordsDoNotMatchException;
import com.finki.ukim.mk.predmetnik.exceptions.UsernameAlreadyExistsException;
import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.models.Program;
import com.finki.ukim.mk.predmetnik.models.Role;
import com.finki.ukim.mk.predmetnik.models.Student;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Optional<Student> findById(Integer id);

    Optional<Student> findByIndexAndPassword(Integer id, String password);

    void save(Student student);


    UserDetails loadUserByUsername(String username);

    Student register(Integer index, String name, String surname, String password, String repeat, Preference preference, Program program, Role role) throws InvalidArgumentsException, PasswordsDoNotMatchException, UsernameAlreadyExistsException;
}