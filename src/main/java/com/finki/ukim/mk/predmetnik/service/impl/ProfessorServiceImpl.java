package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Professor;
import com.finki.ukim.mk.predmetnik.repository.ProfessorRepository;
import com.finki.ukim.mk.predmetnik.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void save(Professor professor) {
        this.professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> findByLink(String link) {
        return this.professorRepository.findByLink(link);
    }
}