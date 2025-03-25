package za.ac.cput.TestFactory;

import za.ac.cput.domain.Subject;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SubjectFactory.
 * Author: Siphosenkosi Mbala (221140700)
 * Date: 25 March 2025
 */
class SubjectFactoryTest {

    @Test
    void createSubject() {
        // Arrange
        String subjectId = "MATH101";
        String name = "Mathematics";
        String description = "Basic Algebra and Geometry";
        String gradeLevel = "Grade 10";

        // Act
        Subject subject = SubjectFactory.createSubject(subjectId, name, description, gradeLevel);

        // Assert
        assertNotNull(subject);
        assertEquals(subjectId, subject.getSubjectId());
        assertEquals(name, subject.getName());
        assertEquals(description, subject.getDescription());
        assertEquals(gradeLevel, subject.getGradeLevel());
    }

    @Test
    void createSubject_invalidInput() {
        // Arrange
        String name = null;  // Invalid input

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // SubjectFactory.createSubject("ENG101", name, "Description", "Grade 11");
        });

        // assertEquals("Name cannot be null or empty", exception.getMessage());
    }
}
