package com.finki.ukim.mk.predmetnik.repository;

import com.finki.ukim.mk.predmetnik.models.Personal;
import com.finki.ukim.mk.predmetnik.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

    Optional<Personal> findByOwner(Student student);

}
