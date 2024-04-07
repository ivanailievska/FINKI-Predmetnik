package com.finki.ukim.mk.predmetnik.repository;

import com.finki.ukim.mk.predmetnik.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
