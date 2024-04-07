package com.finki.ukim.mk.predmetnik.service;

import com.finki.ukim.mk.predmetnik.models.Preference;

import java.util.List;
import java.util.Optional;

public interface PreferenceService {
    List<Preference> findAll();

    void changePreference(Integer id, Integer index);

    Optional<Preference> findById(Integer id);

    void save(Preference preference);

    Optional<Preference> findByName(String preferenceName);
}