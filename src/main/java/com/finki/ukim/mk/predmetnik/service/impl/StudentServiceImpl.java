package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.exceptions.InvalidArgumentsException;
import com.finki.ukim.mk.predmetnik.exceptions.PasswordsDoNotMatchException;
import com.finki.ukim.mk.predmetnik.exceptions.UsernameAlreadyExistsException;
import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.models.Program;
import com.finki.ukim.mk.predmetnik.models.Role;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.repository.StudentRepository;
import com.finki.ukim.mk.predmetnik.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public Optional<Student> findByIndexAndPassword(Integer id, String password) {
        return this.studentRepository.findByIndexAndPassword(id, password);
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.studentRepository.findById(Integer.parseInt(username)).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public Student register(Integer index, String name, String surname, String password, String repeat, Preference preference, Program program, Role role) throws InvalidArgumentsException, PasswordsDoNotMatchException, UsernameAlreadyExistsException {
        if (index == null || password == null || password.isEmpty())
            throw new InvalidArgumentsException();

        if (!password.equals(repeat))
            throw new PasswordsDoNotMatchException();

        if (this.studentRepository.findById(index).isPresent())
            throw new UsernameAlreadyExistsException();

        Student student = new Student(index, name, surname, password, preference, program, role);
        return studentRepository.save(student);
    }


}