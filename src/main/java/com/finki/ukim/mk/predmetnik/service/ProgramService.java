package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.models.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramService {

    /**
     * Finds all programs.
     * @return list of all programs.
     */
    List<Program> findAll();

    /**
     * Finds specific program based on the id.
     * @param id the database id.
     * @return optional program.
     */
    Optional<Program> findById(Integer id);
}