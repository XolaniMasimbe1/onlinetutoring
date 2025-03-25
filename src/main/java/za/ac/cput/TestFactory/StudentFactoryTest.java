package za.ac.cput.TestFactory;

/* Student.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
*/


import za.ac.cput.domain.Student;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

public class StudentFactoryTest {

    @Test
    public void testCreateStudent() {
        Student student = StudentFactory.createStudent("S123", "John", "Doe", "john.doe@example.com");

        assertNotNull(student);
        assertEquals("S123", student.getStudentId());
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("john.doe@example.com", student.getEmail());
    }

    @Test
    public void testCreateStudentWithNullId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent(null, "John", "Doe", "john.doe@example.com");
        });
        assertEquals("Student ID cannot be null", exception.getMessage());
    }

    @Test
    public void testCreateStudentWithEmptyId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent("", "John", "Doe", "john.doe@example.com");
        });
        assertEquals("Student ID cannot be empty", exception.getMessage());
    }

    @Test
    public void testCreateStudentWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StudentFactory.createStudent("S123", "John", "Doe", "invalid-email");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }
}