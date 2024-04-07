package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Professor;
import com.finki.ukim.mk.predmetnik.repository.ProfessorRepository;
import com.finki.ukim.mk.predmetnik.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public void save(Professor professor) {
        this.professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> findByLink(String link) {
        return this.professorRepository.findByLink(link);
    }
}