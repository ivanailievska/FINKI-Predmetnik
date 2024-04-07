package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.models.Professor;

import java.util.Optional;

public interface ProfessorService {
    void save(Professor professor);

    Optional<Professor> findByLink(String link);
}
