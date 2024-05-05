package com.finki.ukim.mk.predmetnik;

import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.repository.PreferenceRepository;
import com.finki.ukim.mk.predmetnik.service.impl.PreferenceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PreferenceServiceImplTest {

    @Mock
    private PreferenceRepository preferenceRepository;
    @Mock
    private Preference preference;

    @InjectMocks
    private PreferenceServiceImpl preferenceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Mocked preferences
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference());
        preferences.add(new Preference());

        // Mocking repository behavior
        when(preferenceRepository.findAll()).thenReturn(preferences);

        // Call the method
        List<Preference> foundPreferences = preferenceService.findAll();

        // Verify the method call
        verify(preferenceRepository, times(1)).findAll();

        // Assertions
        assertNotNull(foundPreferences);
        assertEquals(2, foundPreferences.size());
    }

    @Test
    public void testChangePreference() {
        // Mocked parameters
        Integer id = 1;
        Integer index = 123;

        // Call the method
        preferenceService.changePreference(id, index);

        // Verify the method call
        verify(preferenceRepository, times(1)).changePreference(id, index);
    }

    @Test
    public void testFindById() {
        // Mocked preference
        Integer id = 1;
        Preference preference = new Preference();
        preference.setID(id);

        // Mocking repository behavior
        when(preferenceRepository.findById(id)).thenReturn(Optional.of(preference));

        // Call the method
        Optional<Preference> foundPreferenceOptional = preferenceService.findById(id);

        // Verify the method call
        verify(preferenceRepository, times(1)).findById(id);

        // Assertions
        assertTrue(foundPreferenceOptional.isPresent());
        assertEquals(id, foundPreferenceOptional.get().getID());
    }

    @Test
    public void testFindByName() {
        // Mocked preference
        String preferenceName = "SomePreference";
        Preference preference = new Preference();
        preference.setName(preferenceName);

        // Mocking repository behavior
        when(preferenceRepository.findByName(preferenceName)).thenReturn(Optional.of(preference));

        // Call the method
        Optional<Preference> foundPreferenceOptional = preferenceService.findByName(preferenceName);

        // Verify the method call
        verify(preferenceRepository, times(1)).findByName(preferenceName);

        // Assertions
        assertTrue(foundPreferenceOptional.isPresent());
        assertEquals(preferenceName, foundPreferenceOptional.get().getName());
    }

    @Test
    public void testSave() {
        // Mocked preference
        Preference preference = new Preference();

        // Call the method
        preferenceService.save(preference);

        // Verify the method call
        verify(preferenceRepository, times(1)).save(preference);
    }
}
