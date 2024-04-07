package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Program;
import com.finki.ukim.mk.predmetnik.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Optional<Program> findById(Integer id) {
        return this.programRepository.findById(id);
    }
}