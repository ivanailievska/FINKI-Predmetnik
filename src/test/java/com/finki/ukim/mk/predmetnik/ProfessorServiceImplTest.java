package com.finki.ukim.mk.predmetnik;

import com.finki.ukim.mk.predmetnik.models.Professor;
import com.finki.ukim.mk.predmetnik.repository.ProfessorRepository;
import com.finki.ukim.mk.predmetnik.service.impl.ProfessorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProfessorServiceImplTest {

    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private ProfessorServiceImpl professorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveProfessor() {
        // Mocked professor
        Professor professor = new Professor();
        professor.setLink("http://example.com/professor");

        // Mocking repository behavior
        when(professorRepository.save(any(Professor.class))).thenReturn(professor);

        // Call the method
        professorService.save(professor);

        // Verify the method call
        verify(professorRepository, times(1)).save(any(Professor.class));
    }

    @Test
    public void testFindByLink() {
        // Mocked professor
        String link = "http://example.com/professor";
        Professor professor = new Professor();
        professor.setLink(link);

        // Mocking repository behavior
        when(professorRepository.findByLink(link)).thenReturn(Optional.of(professor));

        // Call the method
        Optional<Professor> foundProfessorOptional = professorService.findByLink(link);

        // Verify the method call
        verify(professorRepository, times(1)).findByLink(link);

        // Assertions
        assertTrue(foundProfessorOptional.isPresent());
        assertEquals(link, foundProfessorOptional.get().getLink());
    }

    @Test
    public void testFindByLink_NotFound() {
        // Mocked professor
        String link = "http://example.com/nonexistent_professor";

        // Mocking repository behavior
        when(professorRepository.findByLink(link)).thenReturn(Optional.empty());

        // Call the method
        Optional<Professor> foundProfessorOptional = professorService.findByLink(link);

        // Verify the method call
        verify(professorRepository, times(1)).findByLink(link);

        // Assertions
        assertFalse(foundProfessorOptional.isPresent());
    }
}
