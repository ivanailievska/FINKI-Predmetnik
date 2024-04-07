package com.finki.ukim.mk.predmetnik.repository;

import com.finki.ukim.mk.predmetnik.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {

}
