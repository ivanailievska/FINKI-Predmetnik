package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.repository.PreferenceRepository;
import com.finki.ukim.mk.predmetnik.repository.StudentRepository;
import com.finki.ukim.mk.predmetnik.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Preference> findAll() {
        return this.preferenceRepository.findAll();
    }

    @Override
    public void changePreference(Integer id, Integer index) {
        Student student = this.studentRepository.findById(index).orElse(null);
        Preference preference = this.preferenceRepository.findById(id).orElse(null);
        Objects.requireNonNull(student).setPreference(preference);
        this.studentRepository.save(student);
    }

    @Override
    public Optional<Preference> findById(Integer id) {
        return this.preferenceRepository.findById(id);
    }

    @Override
    public void save(Preference preference) {
        this.preferenceRepository.save(preference);
    }

    @Override
    public Optional<Preference> findByName(String preferenceName) {
        return this.preferenceRepository.findByName(preferenceName);
    }
}
