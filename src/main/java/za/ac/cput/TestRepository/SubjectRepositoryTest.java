package za.ac.cput.TestRepository;

import za.ac.cput.domain.Subject;
import za.ac.cput.factory.SubjectFactory;
import org.junit.jupiter.api.*;
import za.ac.cput.repository.SubjectRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SubjectRepository.
 * Author: Siphosenkosi Mbala (221140700)
 * Date: 25 March 2025
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SubjectRepositoryTest {
    private static final SubjectRepository repository = new SubjectRepository();
    private static final Subject testSubject = SubjectFactory.createSubject(
            "MATH101",
            "Mathematics",
            "Basic Algebra",
            "Grade 10"
    );

    @Test
    @Order(1)
    void testCreate() {
        Subject created = repository.create(testSubject);
        assertNotNull(created);
        assertEquals(testSubject.getSubjectId(), created.getSubjectId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void testRead() {
        Subject found = repository.read(testSubject.getSubjectId());
        assertNotNull(found);
        assertEquals(testSubject.getName(), found.getName());
        System.out.println("Read: " + found);
    }

    @Test
    @Order(3)
    void testUpdate() {
        Subject updatedSubject = new Subject.Builder()
                .setSubjectId(testSubject.getSubjectId()) // Ensure subjectId is copied
                .setName("Advanced Mathematics")
                .setDescription("Algebra and Calculus")
                .setGradeLevel("Grade 10") // Ensure gradeLevel is copied
                .build();

        Subject updated = repository.update(updatedSubject);
        assertNotNull(updated);
        assertEquals("Advanced Mathematics", updated.getName());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void testDelete() {
        boolean success = repository.delete(testSubject.getSubjectId());
        assertTrue(success);
        assertNull(repository.read(testSubject.getSubjectId()));
        System.out.println("Deleted: " + testSubject.getSubjectId());
    }

    @Test
    @Order(5)
    void testGetAll() {
        // Add some test data
        repository.create(SubjectFactory.createSubject("ENG101", "English", "Literature", "Grade 10"));
        repository.create(SubjectFactory.createSubject("SCI101", "Science", "Physics", "Grade 11"));

        // assertFalse(repository.getAll().isEmpty());
        //assertEquals(2, repository.getAll().size());
        // System.out.println("All Subjects: " + repository.getAll());
    }

    @Test
    void testCreateWithNull() {
        assertThrows(IllegalArgumentException.class, () -> repository.create(null));
    }

    @Test
    void testReadNonExistentId() {
        assertNull(repository.read("NON_EXISTENT"));
    }

    @Test
    void testUpdateNonExistentSubject() {
        Subject nonExistent = SubjectFactory.createSubject("BIO101", "Biology", "Cell Biology", "Grade 9");
        assertNull(repository.update(nonExistent));
    }
}
