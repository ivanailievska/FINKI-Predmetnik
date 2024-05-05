package com.finki.ukim.mk.predmetnik;

import com.finki.ukim.mk.predmetnik.exceptions.InvalidArgumentsException;
import com.finki.ukim.mk.predmetnik.exceptions.PasswordsDoNotMatchException;
import com.finki.ukim.mk.predmetnik.exceptions.UsernameAlreadyExistsException;
import com.finki.ukim.mk.predmetnik.models.Preference;
import com.finki.ukim.mk.predmetnik.models.Program;
import com.finki.ukim.mk.predmetnik.models.Role;
import com.finki.ukim.mk.predmetnik.models.Student;
import com.finki.ukim.mk.predmetnik.repository.StudentRepository;
import com.finki.ukim.mk.predmetnik.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private PasswordEncoder passwordEncoder;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterNewStudent() throws InvalidArgumentsException, PasswordsDoNotMatchException, UsernameAlreadyExistsException {
        // Mocked parameters
        Integer index = 123;
        String name = "John";
        String surname = "Doe";
        String password = "password";
        String repeatPassword = "password";
        Preference preference = new Preference(); // Mock or create an actual object
        Program program = new Program(); // Mock or create an actual object
        Role role = Role.ROLE_USER;

        // Mocked student
        Student student = new Student();
        student.setIndex(index);
        student.setName(name);
        student.setSurname(surname);
        student.setPassword(password);
        student.setPreference(preference);
        student.setProgram(program);
        student.setRole(role);

        // Mocking repository behavior
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.findByIndexAndPassword(index, password)).thenReturn(Optional.empty());

        when(passwordEncoder.encode(password)).thenReturn(password);


        // Call the method
        Student registeredStudent = studentService.register(index, name, surname, password, repeatPassword, preference, program, role);

        // Verify the method calls
        verify(studentRepository, times(1)).save(any(Student.class));
        verify(passwordEncoder, times(1)).encode(password); ///-fix


        // Assertions
        assertNotNull(registeredStudent);
        assertEquals(index, registeredStudent.getIndex());
        assertEquals(name, registeredStudent.getName());
        assertEquals(surname, registeredStudent.getSurname());
        assertEquals(password, registeredStudent.getPassword());
        assertEquals(preference, registeredStudent.getPreference());
        assertEquals(program, registeredStudent.getProgram());





        Integer index1 = 123;
        String name1 = "John";
        String surname1 = "Doe";
        String password1 = "password";
        String repeatPassword1 = "password";
        Preference preference1 = new Preference(); // Mock or create an actual object
        Program program1 = new Program(); // Mock or create an actual object
        Role role1 = Role.ROLE_ADMIN;

        // Mocked student
        Student student1 = new Student();
        student1.setIndex(index1);
        student1.setName(name1);
        student1.setSurname(surname1);
        student1.setPassword(password1);
        student1.setPreference(preference1);
        student1.setProgram(program1);
        student1.setRole(role1);

        // Mocking repository behavior
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.findByIndexAndPassword(index, password)).thenReturn(Optional.empty());

        when(passwordEncoder.encode(password)).thenReturn(password);


        // Call the method
        Student registeredStudent = studentService.register(index, name, surname, password, repeatPassword, preference, program, role);

        // Verify the method calls
        verify(studentRepository, times(1)).save(any(Student.class));
        verify(passwordEncoder, times(1)).encode(password); ///-fix


        // Assertions
        assertNotNull(registeredStudent);
        assertEquals(index, registeredStudent.getIndex());
        assertEquals(name, registeredStudent.getName());
        assertEquals(surname, registeredStudent.getSurname());
        assertEquals(password, registeredStudent.getPassword());
        assertEquals(preference, registeredStudent.getPreference());
        assertEquals(program, registeredStudent.getProgram());
        assertEquals(role, registeredStudent.getRole());

    }

}
