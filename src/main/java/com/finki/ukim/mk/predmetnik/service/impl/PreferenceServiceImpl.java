package com.finki.ukim.mk.predmetnik.service.impl;

import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.repository.PreferenceRepository;
import com.finki.ukim.mk.predmetnik.repository.StudentRepository;
import com.finki.ukim.mk.predmetnik.service.PreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final StudentRepository studentRepository;

    public PreferenceServiceImpl(PreferenceRepository preferenceRepository,
                                 StudentRepository studentRepository) {
        this.preferenceRepository = preferenceRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Preference> findAll() {
        return this.preferenceRepository.findAll();
    }

    @Override
    public void changePreference(Integer id, Integer index) {
        Student student = this.studentRepository.findById(index).get();
        Preference preference = this.preferenceRepository.findById(id).get();
        student.setPreference(preference);
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
