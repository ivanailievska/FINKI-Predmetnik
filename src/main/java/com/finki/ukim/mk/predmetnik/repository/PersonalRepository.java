package com.finki.ukim.mk.predmetnik.repository;

import com.finki.ukim.mk.predmetnik.models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
}
