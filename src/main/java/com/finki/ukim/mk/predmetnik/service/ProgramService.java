package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.models.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramService {
    List<Program> findAll();

    Optional<Program> findById(Integer id);
}